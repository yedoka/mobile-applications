package com.mobileapps.lesson2

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = Regex(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@" + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|" + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        )
        return email.matches(emailRegex)
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }
    val credentials = mutableMapOf(
        Pair("test@te.st", "1234")
    )
    fun checkIfEmailExists(email:String):Boolean{
        return credentials.contains(email.lowercase())
    }
    fun register(fullName:String, email: String,phoneNumber:String,password: String): Boolean{
        if (isEmailValid(email) && isValidPassword(password)){
            credentials[email.lowercase()] = password
            return true
        }
        return false
    }
    fun login(email:String,password: String) : Boolean{
        return checkIfEmailExists(email) && credentials[email.lowercase()] == password
    }
}