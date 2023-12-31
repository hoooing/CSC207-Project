# CSC207 Project - N2NChat (End-to-End Encrypted Messenger)
<img width="80" alt="n2nlogo" src="https://github.com/hoooing/CSC207-Project/assets/88988698/90b2bdb3-908c-41aa-a162-fa342f06300d">
"What is said in the room stays in the room."

# Contributors
* [DaeChan Eom](https://github.com/daechan0615)
* [DongHyeon Kim](https://github.com/hoooing)
* [Victor Su](https://github.com/VictorSu33)
* [Justin Yoon](https://github.com/justinyoon95)

# About
Our project is to create an application providing an End-to-End Encrypted messaging service (including file sharing, and group chats), ensuring security and privacy by encrypting (converting data into a text format that is not immediately human-readable) the messages and can only be decrypted (reverses the encrypted data back to a readable format) by the recipient. This guarantees no one other than the parties in the chat has access to the messages in the chat, even the application admins. In summary, the fundamental idea is 'what is said in the room stays in the room'. 
# API Documentation Link
* [Virgil E3Kit](https://developer.virgilsecurity.com/docs/e3kit): This API will be responsible for encryption/decryption methods.
* [Random word API](https://random-word-api.herokuapp.com/home): This API will be responsible for giving random words to generate recovery phrase.

# Sample Usage of the APIs
This is a screenshot of trying out the Virgil E3Kit API.

<img width="700" alt="encryption_example" src="https://github.com/hoooing/CSC207-Project/assets/88988698/cf30da34-4bfa-4011-909a-0bf70cba1258">
(This is an example of encrypting data)

<img width="700" alt="decryption_example" src="https://github.com/hoooing/CSC207-Project/assets/88988698/0d22d20f-0c63-492d-a334-62ca190502ce">
(This is an example of decrypting data)

![recoveryphrase_example](https://github.com/hoooing/CSC207-Project/assets/88988698/4e9d7ab3-15db-439b-8eea-0c8050e553a0)
(This is an example of generating a recovery phrase consisting of 12 randomly generated words from the API dictionary)
Example Output: Recovery Phrase: "argentous" "mummichog" "melancholiacs" "chinchiest" "preceptor" "shortcuts" "ascendent" "melancholiacs" "preordain" "cytoskeleton" "argentous" "spiffing"


# Technical Problems
TBA
