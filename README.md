# BDCC AI Agent

This project is a RAG-based AI agent built with Spring Boot and Spring AI, using Ollama and the Mistral model. It allows users to ask questions and get answers from an AI model that can be augmented with knowledge from uploaded documents.

## API Endpoints

### Ask a Question

- **Endpoint:** `GET /askAgent`
- **Method:** `GET`
- **Description:** Sends a query to the AI agent and streams the response back.
- **Parameters:**
  - `query` (optional, string): The question to ask the agent. Defaults to "Hello".
- **Example:**
  ```bash
  curl "http://localhost:8080/askAgent?query=What%20is%20the%20capital%20of%20France%3F"
  ```

### Upload a Document

- **Endpoint:** `POST /loadFile`
- **Method:** `POST`
- **Description:** Uploads a PDF document to be indexed and used by the AI agent for answering questions.
- **Request Body:** `multipart/form-data`
  - `file`: The PDF file to upload.
- **Example:**
  ```bash
  curl -X POST -F "file=@/path/to/your/document.pdf" http://localhost:8080/loadFile
  ```

## Project Structure

- **`AgentController.java`**: The main controller that exposes the API endpoints for interacting with the AI agent.
- **`AIAgent.java`**: The core of the AI agent, responsible for processing user queries and interacting with the Spring AI `ChatClient`.
- **`DocumentIndexor.java`**: Handles the indexing of uploaded PDF documents. It splits the documents into chunks and stores them in a vector store for efficient retrieval.
- **`BdccAiAgentApplication.java`**: The main Spring Boot application class.

## Setup and Running

1. **Prerequisites:**
   - Java 21 or higher
   - Maven
   - Ollama installed and running. You can download it from [https://ollama.ai/](https://ollama.ai/).
   - The Mistral model installed in Ollama. You can install it by running:
     ```bash
     ollama pull mistral
     ```

2. **Configuration:**
   - The application is configured to connect to Ollama at `http://localhost:11434` and use the `mistral` model by default. You can change these settings in `src/main/resources/application.properties`.

3. **Running the Application:**
   - Use the following Maven command to run the application:
     ```bash
     ./mvnw spring-boot:run
     ```
   - The application will be available at `http://localhost:8080`.