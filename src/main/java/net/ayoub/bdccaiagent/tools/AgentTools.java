package net.ayoub.bdccaiagent.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class AgentTools {
    @Tool(description = "Get Information about an employee (name, salary, seniority)")
    public EmployeeInfo getEmployeeInfo(@ToolParam(description = "Employee Name") String employeeName) {
        return new EmployeeInfo(
                employeeName, 13000, 5
        );
    }
}

record EmployeeInfo(String name, double salary, int seniority) {}