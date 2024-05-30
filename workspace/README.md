# Getting Started with Azure OpenAI and Spring

This project is a sample application for Spring AI and Azure OpenAI.

## Description

### 0. Ask GitHub Copilot Chat for Spring AI

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/27d56084-53a5-4a10-9b2a-528e07badd5a)

### 1. Install Spring Boot CLI

```shell
sdk install springboot
```

### 2. Create and Deploy an Azure OpenAI Service resource

- [Guide](https://learn.microsoft.com/en-us/azure/ai-services/openai/how-to/create-resource?pivots=web-portal)

#### 2.1 Create a Resource Group

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/c95032c6-fe74-4e8c-8bad-373b0bc8179e)

Create a Resource Group for Azure OpenAI Service.

#### 2.2 Create an Azure OpenAI Service resource

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/1d4a5378-c44f-4f56-869b-13bf7aebfa62)

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/595856c6-effb-4db5-ad41-21105f249cf7)

Create an Azure OpenAI Service with the resource group created in the previous step.

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/fa5e844d-d652-4b37-9bee-ca747f98f586)

- Option 1: Allow all networks
  - The first option allows all networks, including the internet, to access your resource. This option is the default setting. No extra settings are required for this option.

And then, Create the Azure OpenAI Service.

#### 2.3 Get the API Key

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/d0a73fea-3ede-4923-8314-852be2884374)

Go to resouce, and confirm the Azure OpenAI Service resource created.

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/6f641711-2960-48d2-bf8c-a9ca682c4e60)

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/1c5098a3-f441-4e49-b2f4-c50e90ada803)


Then you can get the API Key from the `Keys and Endpoint` menu.


#### 2.4 Deploy a Model

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/0569602a-99ff-44dc-b461-b06ce7c7dda9)

Open the Azure OpenAI Studio.
- [Azure OpenAI Studio](https://oai.azure.com/portal)

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/15981cdd-3208-4789-bb7f-fd30abd59f84)

Select **Deployments** under **Management**.


![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/fca4cd92-37b4-4ecf-a8c5-664eb2f4e1b1)

![Image](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/8ec932ee-af8f-494a-826c-2bd659c554ad)

Select Model and confgure the deployment.

I selected deployment name as `shinyay-gpt`, which is used in your code to call the model by using the client libraries and the REST APIs.

### 3. Create a Spring Boot Application

Create a Spring Boot Application with Spring AI for Azure OpenAI Service.

#### 3.1 Create a project template with Spring Initializr

- [Spring Initializr](https://start.spring.io/)
  - [Spring AI](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.6&packaging=jar&jvmVersion=21&groupId=com.microsoft.shinyay&artifactId=java-on-azure&name=java-on-azure&description=Demo%20project%20for%20Spring%20AI&packageName=com.microsoft.shinyay.ai&dependencies=spring-ai-azure-openai)
![aoai](https://github.com/shinyay/getting-started-with-azure-openai/assets/3072734/f19ea71b-1fc0-4b86-8404-ff451d33127c)

Choose Azure OpenAI for Dependency.

#### 3.2 Issue for Modify a project template

- Issue Title: **Maven Project with Spring AI and Azure OpenAI**

```markdown
- Create a Spring Project with Spring AI
- Spring Boot version is 3.3.0
- Spring AI version is 1.0.0-M1
- Use spring-ai-azure-openai-spring-boot-starter
- Build tool is Maven
- Java version is 21
- Group ID is com.microsoft.shinyay.ai
- Artifact ID is java-on-azure
- Name is Java on Azure
```

#### 3.3 Issue for Properties for Spring AI

- Issue Title: **Add application.yml for Azure OpenAI Service**

```markdown
- Add application.yml under resources
- Add the following properties to application.yml
  - spring.ai.azure.openai.api-key=${SPRING_AI_AZURE_OPENAI_API_KEY}
  - spring.ai.azure.openai.endpoint=${SPRING_AI_AZURE_OPENAI_ENDPOINT}
  - spring.ai.azure.openai.chat.options.deployment-name=${SPRING_AI_AZURE_OPENAI_CHAT_OPTIONS_DEPLOYMENT_NAME}
```

#### 3.4 Issue for REST Controller to Azure OpenAI Service

- Title: **Create a REST Controller for Azure OpenAI Service**

```markdown
- Add Spring Boot Starter Web into pom.xml
- Add a REST controller class named by SimpleAiController
- Import org.springframework.ai.chat.client.ChatClient
- Initialize ChatClient using ChatClient.Builder.build()
- Using ChatClient, add a method to send a prompt to Azure OpenAI and invoke a response
  - GET Method with "/prompt" endpoint
  - Parameter is prompt
  - Use chatClient.prompt().user().call().content() to interact with Azure OpenAI
```

- Add Plan depends as needed

```markdown
Use chatClient.prompt().user(userInput).call().content(); to interact with Azure OpenAI.
```
```markdown
use ChatClient.Builder.build(); to initialize ChatClient.
```

#### 3.5 Issue for ChatClient for prompt message

- Title: **Create a method for prompt**

```markdown
- Add a method to generate prompt, send Azure OpenAI and receive response
- Method name is "callAzureOpenAI"
- This methos is accessed with GET METHOD
- Endpoint is "/prompt"
- Parameter value is "prompt"
- Parameter default value is "Tell me the benefit of Spring Framework in Japanese"
- Use call method with ChatClient when you call Azure OpenAI Service
  - Use chatClient.prompt().user().call().content() to interact with Azure OpenAI
```

or

```markdown
- Add a method to generate message with Azure OpenAI
- Default value of the parameter is "Tell me about the benefit of Spring Framework"
```


#### 3.6 Issue for view for prompt message

- Title: **Create a view for SimpleViewController with Thymeleaf**

```markdown
- Add a Thymeleaf dependency into pom.xml
- Create a contorller class named by SimpleViewController
- Add a thyemleaf view for SimpleViewController
- The view should have the following 4 components.
  - Text box to input a prompt
  - Text aria to display the result from SimpleViewController
  - Button to submit prompt
  - Button to clear the text field
- Add a method to hahdle post request from the view
  - The method should return the view
  - The method should have a model attribute to pass the view
  - The method should call the generate method from SimpleAiController
  - The method should set the result to the model attribute
- Decorate the screen by adding nice CSS
```

## Demo

```shell
curl -X GET http://localhost:8080/ai/recipe
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

- [Quickstart: Get started generating text using Azure OpenAI Service](https://learn.microsoft.com/en-us/azure/ai-services/openai/quickstart?pivots=programming-language-spring&tabs=command-line%2Cpython-new)

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/f3ac65a05ed8c8ea70b653875ccac0c6dbc10ba1/LICENSE)

## Author

- github: <https://github.com/shinyay>
- twitter: <https://twitter.com/yanashin18618>
- mastodon: <https://mastodon.social/@yanashin>
