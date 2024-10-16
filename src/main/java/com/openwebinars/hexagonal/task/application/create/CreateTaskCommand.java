package com.openwebinars.hexagonal.task.application.create;

import com.openwebinars.hexagonal.shared.validation.SelfValidating;
import com.openwebinars.hexagonal.user.domain.model.UserId;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

/*public record CreateTaskCommand(
        String title,
        String description,
        UserId author) {
}
*/
@Getter
@Accessors(fluent = true) // Así los getters no llevan prefijo get y no cambia el código respecto a un record
public class CreateTaskCommand extends SelfValidating<CreateTaskCommand> {

    @NotBlank(message = "title cannot be blank")
    private final String title;

    @NotBlank(message = "description cannot be blank")
    private final String description;

    private final UserId author;

    @Builder
    public CreateTaskCommand(String title, String description, UserId author) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.validateSelf();
    }
}
