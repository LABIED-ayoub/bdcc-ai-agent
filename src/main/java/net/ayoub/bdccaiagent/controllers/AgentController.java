package net.ayoub.bdccaiagent.controllers;

import net.ayoub.bdccaiagent.agents.AIAgent;
import net.ayoub.bdccaiagent.rag.DocumentIndexor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class AgentController {
    private AIAgent agent;
    private DocumentIndexor indexor;

    public AgentController(AIAgent agent, DocumentIndexor indexor) {
        this.agent = agent;
        this.indexor = indexor;
    }

    @GetMapping(value = "/askAgent", produces =  MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> askAgent (@RequestParam(defaultValue = "Hello") String query) {
        return agent.onQuery(query);
    }

    @PostMapping(value = "/loadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces =  MediaType.MULTIPART_FORM_DATA_VALUE)
    public void loadFile(@RequestPart("file") MultipartFile file) throws IOException {
        indexor.loadFile(file);
    }

//    @GetMapping("/askAgent")
//    public Flux<String> askAgent (@RequestParam(defaultValue = "Hello") String query) {
//        return chatClient.prompt()
//                .user(query)
//                .stream().content();
//    }
}
