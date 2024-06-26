# Getting Started with Azure OpenAI and Spring

This project is a sample application for Spring AI and Azure OpenAI.

## Description

The detailed procedure is written in the following document:

- [README.md](./workspace/README.md)

## Demo

Start from `ctrl + shift + p` and select `Dev Container: Rebuid and Reopen in Container`

### Reset Project

- Remove the following files and directories

```shell
git rm workspace/src/main/java/com/microsoft/shinyay/ai/SimpleAiController.java
git rm workspace/src/main/java/com/microsoft/shinyay/ai/SimpleViewController.java
git rm -r workspace/src/main/resources/templates
git rm -r workspace/src/main/resources/static
```

- Blank the following files
  - workspace/src/main/resources/application.yml

- Edit pom.xml to its initial state
  - Remove the following dependencies
    - spring-boot-starter-web
    - spring-boot-starter-thymeleaf
  - Change Spring Boot version to 3.2.6
  - Change Spring AI version to 0.8.1
  - Change Artifact ID to demo
  - Change Application Name to demo
  - Change Group ID to com.example


## Features

- feature:1
- feature:2

## Requirement

- [Visual Studio Code - Insiders](https://code.visualstudio.com/insiders/)
- [Visual Studio Code - Remote SSH](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-ssh)

## Prerequisites

- An Azure subscription - [Create one for free](https://azure.microsoft.com/free/cognitive-services?azure-portal=true)
- Access granted to the Azure OpenAI service in the desired Azure subscription. Currently, access to this service is granted only by application. You can apply for access to Azure OpenAI Service by completing the form at [https://aka.ms/oai/access](https://aka.ms/oai/access?azure-portal=true).
- The current version of the [Java Development Kit (JDK)](https://www.microsoft.com/openjdk)
- The [Spring Boot CLI tool](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing.cli)
- An Azure OpenAI Service resource with the gpt-3.5-turbo model deployed. For more information about model deployment, see the [resource deployment guide](https://learn.microsoft.com/en-us/azure/ai-services/openai/how-to/create-resource).

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/f3ac65a05ed8c8ea70b653875ccac0c6dbc10ba1/LICENSE)

## Author

- github: <https://github.com/shinyay>
- twitter: <https://twitter.com/yanashin18618>
- mastodon: <https://mastodon.social/@yanashin>
