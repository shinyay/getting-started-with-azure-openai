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

#### 3.2 Modify a project template with Copilot Workspace

```markdown
- Create a Spring Project with Spring AI
- Spring AI version is 0.8.1
- Use spring-ai-azure-openai-spring-boot-starter
- Build tool is Maven
- Java version is 21
- Group ID is com.microsoft.shinyay
- Artifact ID is java-on-azure
```

#### 3.3 Properties for Spring AI

```markdown
- Add application.yml under resources
- Add the following properties to application.yml
  - spring.ai.azure.openai.api-key="YOUR_API_KEY"
  - spring.ai.azure.openai.endpoint="YOUR_ENDPOINT"
  - spring.ai.azure.openai.embedding.options.deployment-name="YOUR_MODEL_NAME"
```

#### 3.4 Create a REST Controller

```markdown
- Add Spring Boot Starter Web into pom.xml
- Add a REST controller class named by SimpleAiController
- Import org.springframework.ai.chat.ChatClient
- Initialize ChatClient with Constructor Dependency Injection
```

#### 3.5 Prompt for Azure OpenAI Service

```markdown
- Add a method to generate message with Azure OpenAI
- Method name is "generate"
- This methos is accessed with GET METHOD
- Endpoint is "/ai/recipe"
- Parameter value is message
- Parameter default value is "Tell me a decliciou food recipe in Japanese"
- Use call method with ChatClient when you call Azure OpenAI Service
```

#### 3.6 View for prompt message

```markdown
- Create a view for SimpleAiController with Thymeleaf
- The view should have 4 component. One is the text box to input a prompt. The other is a text field to display the result from SimpleAiContoller. And The last ones are a button to submit prompt and clear the text field.
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
