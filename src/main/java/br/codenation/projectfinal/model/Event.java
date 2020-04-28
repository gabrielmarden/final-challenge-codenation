package br.codenation.projectfinal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="Class represents the details of the log")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="Unique id automatically created",required = false)
    private Long id;

    @NotEmpty
    @ApiModelProperty(notes="Description of the log",required = true)
    private String description;

    @NotEmpty
    @Column(name="event_log")
    @ApiModelProperty(notes = "Log details",required = true)
    private String log;

    @CreatedBy
    @ApiModelProperty(notes = "Log origin/creator. Automatically filled in with the username of the logged in User.",required = false)
    private String origin;

    @Column(name="created_at")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "Log creation date. Automatically created by the system",required = false)
    private Date createdAt;

    @ApiModelProperty(notes = "Log level",required = true)
    private String level;


}
