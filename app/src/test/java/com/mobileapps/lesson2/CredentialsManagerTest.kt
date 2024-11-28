package com.mobileapps.lesson2

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CredentialsManagerTest {

    private lateinit var credentialsManager: CredentialsManager

    @Before
    fun setUp() {
        credentialsManager = CredentialsManager()
    }

    // Email Tests

    @Test
    fun email_isEmpty_returnsFalse() {
        val result = credentialsManager.isEmailValid("")
        assertFalse("Expected false for empty email", result)
    }

    @Test
    fun email_isInvalidFormat_returnsFalse() {
        val result = credentialsManager.isEmailValid("invalidEmailFormat")
        assertFalse("Expected false for invalid email format", result)
    }

    @Test
    fun email_isValidFormat_returnsTrue() {
        val result = credentialsManager.isEmailValid("test@example.com")
        assertTrue("Expected true for valid email format", result)
    }

    // Password Tests

    @Test
    fun password_isEmpty_returnsFalse() {
        val result = credentialsManager.isValidPassword("")
        assertFalse("Expected false for empty password", result)
    }

    @Test
    fun password_isFilled_returnsTrue() {
        val result = credentialsManager.isValidPassword("password123")
        assertTrue("Expected true for filled password", result)
    }

    @Test
    fun givenCorrectCredentialsFormatWhenRegister(){
        credentialsManager.register("Full name", "test@example.com","9483893843","1234")
        val isRegisterSuccessful = credentialsManager.credentials.contains("test@example.com") && credentialsManager.credentials["test@example.com"] == "1234"
        assertEquals(true,isRegisterSuccessful)
    }

    @Test
    fun givenUpperCaseCredentialsFormatWhenRegister(){
        credentialsManager.register("Full name", "Test2@example.com","9483893843","1234")
        val isRegisterSuccessful = credentialsManager.credentials.contains("test2@example.com") && credentialsManager.credentials["test2@example.com"] == "1234"
        assertEquals(true,isRegisterSuccessful)
    }
    @Test
    fun givenEmailAllreadyExist(){
        val email = "test@te.st"
        assertEquals(true,credentialsManager.checkIfEmailExists(email))
    }
    @Test
    fun givenEmailDoesNotExist(){
        val email = "Test3@example.com"
        assertEquals(false,credentialsManager.checkIfEmailExists(email))
    }
}
