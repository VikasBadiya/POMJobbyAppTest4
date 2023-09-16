In this exercise, you will be automating the process of testing the Jobby App using Page Object Model.

### Prerequisites

- Install IntelliJ IDEA Community IDE  Version 2018.3.6.
- Install OpenJDK 11 and complete the configuration.
- Install a Browser Driver(Chrome Driver).
- Setup a Selenium project with the name `JobbyAppTest4`.
- Update the Build in `pom.xml`. Refer to previous exercises for reference.

You can refer to this [Reading Material](https://learning.ccbp.in/qa-automation-testing/course?c_id=cf952b35-27ab-4b1e-a6de-44227f22806c&s_id=f5c19277-3889-4e63-b631-c06c088d612c&t_id=6a935df7-2c93-477c-b505-3ae0aabcf9a2#31-installing-ide) to complete the above prerequisites.

**Application URL**: `https://qajobbyapp.ccbp.tech/login`

### Test Instructions

- Create a new package `pages` in the `src/test/java` directory.
- Create a `LoginPage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Login page</summary>
    >  - App logo image
    >  - List of label texts
    >  - "USERNAME" input field
    >  - "PASSWORD" input field
    >  - "Login" button
    >  - Error message text
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Find the App logo image
    >  - Get the text content of the label at a specific index
    >  - Enter a text in the "USERNAME" input field
    >  - Enter a text in the "PASSWORD" input field
    >  - Click the "Login" button
    >  - Enter with the given credentials and click the "Login" button
    >  - Wait and get the text content of the error message
    </details>
- Create a `HomePage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Home page</summary>
    >  - Heading text
    >  - Description text
    >  - "Find Jobs" button
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Get the text content of the Heading
    >  - Get the text content of the Description
    >  - Click the "Find Jobs" button
    </details>
- Create a `HeaderSection` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Header section</summary>
    >  - App logo image
    >  - App logo link
    >  - Navbar Home link
    >  - Navbar Jobs link
    >  - "Logout" button
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Find the App logo image
    >  - Click the App logo link
    >  - Click the Navbar Home link
    >  - Click the Navbar Jobs link
    >  - Click the "Logout" button
    >  - Logout of the application, by accepting the alert
    </details>
- Create a `JobsPage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Header section</summary>
    >  - Profile image
    >  - Profile name
    >  - Short bio text
    >  - Search input field
    >  - Search button
    >  - List of all jobs displayed
    >  - No jobs found image
    >  - No jobs found heading
    >  - No jobs found description
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Find the Profile image
    >  - Get the text content of the Profile name
    >  - Get the text content of the Short bio text
    >  - Enter a text in the Search input field
    >  - Click the Search button
    >  - Search for a job with the specified text
    >  - Get the Count of all jobs displayed
    >  - Find the No jobs found image
    >  - Get the text content of the No jobs found heading
    >  - Get the text content of the No jobs found description
    </details>
- Create a `LoginPageTest` class and write the test cases for the below test scenarios,
    _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Login Page UI</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Verify if the App logo is displayed - _use Assertions_,
    >    - If the App logo is not displayed, print "App logo is not displayed"
    >- Verify the Username label text - _use Assertions_,
    >    - Expected text: `USERNAME`
    >    - If the Label text does not match the expected text, print "Username label text does not match"
    >- Verify the Password label text - _use Assertions_,
    >    - Expected text: `PASSWORD`
    >    - If the Label text does not match the expected text, print "Password label text does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty input fields</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Click the "Login" button.
    >- Wait and verify the error message - _use Assertions_,
    >    - Expected text: `*Username or password is invalid`
    >    - If the error message does not match the expected text, print "Error text with empty input fields does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty Username field</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, only with the Password `rahul@2021`.
    >- Wait and verify the error message - _use Assertions_,
    >    - Expected text: `*Username or password is invalid`
    >    - If the error message does not match the expected text, print "Error text with empty input field do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty Password field</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, only with the Username `rahul`.
    >- Wait and verify the error message - _use Assertions_,
    >    - Expected text: `*Username or password is invalid`
    >    - If the error message does not match the expected text, print "Error text with empty input field do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with invalid Password</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul`.
    >- Wait and verify the error message - _use Assertions_,
    >    - Expected text: `*username and password didn't match`
    >    - If the error message does not match the expected text, print "Error text with invalid password do not match"
    >- Close the browser window.
    </details>

    <details>
    <summary>Test the successful login</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait and verify the navigation to the home page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>
- Create a `HeaderSectionTest` class and write the test cases for the below test scenarios,
    _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the App logo image</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Verify if the App logo is displayed - _use Assertions_,
    >    - If the App logo is not displayed, print "App logo is not displayed"
    >- Close the browser window.
    </details>

    <details>
    <summary>Test the navigation by clicking the Navbar Jobs link</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the Navbar Jobs link.
    >- Verify the navigation to the jobs page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/jobs`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>

    <details>
    <summary>Test the navigation by clicking the App logo link</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the Navbar Jobs link.
    >- Click the App logo link
    >- Verify the navigation to the home page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>

    <details>
    <summary>Test the navigation by clicking the Navbar Home link</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the Navbar Jobs link.
    >- Click the Navbar Home link
    >- Verify the navigation to the home page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>

    <details>
    <summary>Test the logout button functionality</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Logout of the application.
    >- Verify the navigation to the login page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/login`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>
- Create a `HomePageTest` class and write the test cases for the below test scenarios,
    _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Homepage Heading</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Verify the Heading text of the home page - _use Assertions_,
    >    - Expected text: `Find The Job That Fits Your Life`
    >    - If the Heading text does not match the expected text, print "Heading text does not match" 
    >- Verify the Description text of the home page - _use Assertions_,
    >    - Expected text: `Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.`
    >    - If the Description text does not match the expected text, print "Description text does not match" 
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the Find Jobs button functionality</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the "Find Jobs" button.
    >- Verify the navigation to the jobs page - _use Assertions_
    >    - Expected URL: `https://qajobbyapp.ccbp.tech/jobs`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>
- Create a `JobsPageTest` class and write the test cases for the below test scenarios,
    _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Profile Container UI</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the "Find Jobs" button.
    >- Verify if the Profile image is displayed - _use Assertions_,
    >    - If the Profile image is not displayed, print "Profile image is not displayed"
    >- Verify the Profile name text - _use Assertions_,
    >    - Expected text: `Rahul Attluri`
    >    - If the Profile name does not match the expected text, print "Profile name does not match"
    >- Verify the Short bio text - _use Assertions_,
    >    - Expected text: `Lead Software Developer and AI-ML expert`
    >    - If the Short bio text does not match the expected text, print "Bio does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the Successful Search</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the "Find Jobs" button.
    >- Test the search functionality of the Jobs Page using various inputs from the given dataset.
    >
    >    **Dataset**
    >    
    >    |     Search Text     | Expected Number of Jobs |
    >    | :-----------------: | :---------------------: |
    >    |   Devops Engineer   |            9            |
    >    |  Backend Engineer   |           11            |
    >    |  Frontend Engineer  |           13            |
    >    | Fullstack Developer |            6            |
    >    |   Data Scientist    |           11            |
    >    |     ML Engineer     |           10            |
    >    
    >   - Search for the job with the search text.
    >   - Verify the Jobs count - _use Assertions_,
    >       - If the Jobs count does not match the expected count, print "Jobs count does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the Unsuccessful Search</summary>
    >- Navigate to the URL `https://qajobbyapp.ccbp.tech/login`
    >- Login to the application, with the Username `rahul` and Password `rahul@2021`.
    >- Wait until the web driver navigates to the home page
    >    - Home Page URL: `https://qajobbyapp.ccbp.tech/`
    >- Click the "Find Jobs" button.
    >- Search for the job with the text `Netflix`.
    >- Verify if the No Jobs Found image is displayed - _use Assertions_,
    >    - If the No Jobs Found image is not displayed, print "Jobs not found image is not displayed"
    >- Verify the No Jobs Found heading text - _use Assertions_,
    >    - Expected text: `No Jobs Found`
    >    - If the No Jobs Found heading does not match the expected text, print "Jobs not found heading does not match"
    >- Verify the No Jobs Found description text - _use Assertions_,
    >    - Expected text: `We could not find any jobs. Try other filters.`
    >    - If the No Jobs Found description does not match the expected text, print "Jobs not found description does not match"
    >- Close the browser window.
    </details>

### Running Tests

- Use Parallel testing with _parallel_ attribute values as **classes** and _thread-count_ required for the tests to run parallel.

<br>
<br>

**Note: Set up the project and practice this exercise in your local IDE(IntelliJ).**