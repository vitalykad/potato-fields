package org.funkntrash.potato.nasa.entities;

/**
 * Created by root on 09.05.16.
 */
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "sol",
        "camera",
        "img_src",
        "earth_date",
        "rover"
})
public class Photo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sol")
    private Integer sol;
    @JsonProperty("camera")
    private Camera camera;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private String earthDate;
    @JsonProperty("rover")
    private Rover rover;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The sol
     */
    @JsonProperty("sol")
    public Integer getSol() {
        return sol;
    }

    /**
     *
     * @param sol
     * The sol
     */
    @JsonProperty("sol")
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    /**
     *
     * @return
     * The camera
     */
    @JsonProperty("camera")
    public Camera getCamera() {
        return camera;
    }

    /**
     *
     * @param camera
     * The camera
     */
    @JsonProperty("camera")
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     *
     * @return
     * The imgSrc
     */
    @JsonProperty("img_src")
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     *
     * @param imgSrc
     * The img_src
     */
    @JsonProperty("img_src")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    /**
     *
     * @return
     * The earthDate
     */
    @JsonProperty("earth_date")
    public String getEarthDate() {
        return earthDate;
    }

    /**
     *
     * @param earthDate
     * The earth_date
     */
    @JsonProperty("earth_date")
    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    /**
     *
     * @return
     * The rover
     */
    @JsonProperty("rover")
    public Rover getRover() {
        return rover;
    }

    /**
     *
     * @param rover
     * The rover
     */
    @JsonProperty("rover")
    public void setRover(Rover rover) {
        this.rover = rover;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}