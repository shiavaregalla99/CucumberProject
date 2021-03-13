Feature: Login Functionality
@smoke
Scenario: Login into the application with valid credentails

When   User Enters credentials "admin176" and "admin123" 
And    User Clicks on the login button
Then   User Successfully login into the application

@smoke1
Scenario: Login into the application with invalid credentails

When   User Enters credentials "admin176" and "admin123" 
And    User Clicks on the login button
Then   User should be able to see error message as "Invalid credentials"

@DataDrivenTesting
Scenario Outline: Login into the application with invalid testData

When   User Enters credentials "<username>" and "<password>" 
And    User Clicks on the login button
Then   User should be able to see error message as "<errorMessage>"

Examples:
|username        | password          | errorMessage       |
|Admin123        | admin123          |Invalid credentials |
|Admin           | admin12387        |Invalid credentials |
|Admin123        | admin12356        |Invalid credentials |
|                | admin123          |Username cannot be empty |
| admin          |                   |Password cannot be empty |

@MapsDriven
Scenario: Login into the application with invalid testData

When User enters invalid username and password and see error message
|username        | password          | errorMessage       |
|Admin123        | admin123          |Invalid credentials |
|Admin           | admin12387        |Invalid credentials |
|Admin123        | admin12356        |Invalid credentials |
|                | admin123          |Username cannot be empty |
| admin          |                   |Password cannot be empty |

