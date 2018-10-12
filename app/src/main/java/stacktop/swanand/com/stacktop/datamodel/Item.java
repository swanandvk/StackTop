package stacktop.swanand.com.stacktop.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Item {

    @Ignore
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    @Embedded
    @SerializedName("owner")
    @Expose
    private Owner owner;

    @SerializedName("is_answered")
    @Expose
    private Boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("answer_count")
    @Expose
    private Integer answerCount;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;

    @PrimaryKey
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("last_edit_date")
    @Expose
    private Integer lastEditDate;
    @SerializedName("closed_date")
    @Expose
    private Integer closedDate;
    @SerializedName("closed_reason")
    @Expose
    private String closedReason;


    public Item(Owner owner, Boolean isAnswered, Integer viewCount, Integer answerCount, Integer score, Integer lastActivityDate, Integer creationDate, Integer questionId, String link, String title, Integer lastEditDate, Integer closedDate, String closedReason) {
        this.owner = owner;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.questionId = questionId;
        this.link = link;
        this.title = title;
        this.lastEditDate = lastEditDate;
        this.closedDate = closedDate;
        this.closedReason = closedReason;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Integer getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Integer closedDate) {
        this.closedDate = closedDate;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

}
