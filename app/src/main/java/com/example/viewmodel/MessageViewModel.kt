import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Injection
import com.example.data.Message
import com.example.data.MessageRepository
import com.example.data.AppResult
import com.example.data.User
import com.example.data.UserRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    private val _roomId = MutableLiveData<String>()
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> get() = _currentUser

    // repositories
    private val messageRepository: MessageRepository
    private val userRepository: UserRepository

    init {
        messageRepository = MessageRepository(Injection.instance())
        userRepository = UserRepository(
            FirebaseAuth.getInstance(),
            Injection.instance()
        )
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            when (val result = userRepository.getCurrentUser()) {  // ✅ fixed instance call
                is AppResult.Success -> _currentUser.value = result.data
                is AppResult.Error -> {  // ✅ fixed incorrect 'Error'
                }
                else -> Unit
            }

        }
    }

    fun loadMessages() {
        viewModelScope.launch {
            val roomId = _roomId.value ?: return@launch
            messageRepository.getChatMessages(roomId)
                .collect { _messages.value = it }
        }
    }

    fun sendMessage(text: String) {
        val currentUser = _currentUser.value ?: return
        val roomId = _roomId.value ?: return

        val message = Message(
            senderFirstName = currentUser.firstName,
            senderId = currentUser.email,
            text = text,
            timestamp = null,
            isSentByCurrentUser = true
        )

        viewModelScope.launch {
            when (messageRepository.sendMessage(roomId, message)) {
                is AppResult.Success -> Unit
                is AppResult.Error -> {
                    // Handle message send error
                }
                else -> Unit
            }

        }
    }

    fun setRoomId(roomId: String) {
        _roomId.value = roomId
        loadMessages()
    }
}
