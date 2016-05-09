package org.funkntrash.potato.nasa.entities;

/**
 * Created by root on 09.05.16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        "name",
        "landing_date",
        "max_sol",
        "max_date",
        "total_photos",
        "cameras"
})
public class Rover {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("landing_date")
    private String landingDate;
    @JsonProperty("max_sol")
    private Integer maxSol;
    @JsonProperty("max_date")
    private String maxDate;
    @JsonProperty("total_photos")
    private Integer totalPhotos;
    @JsonProperty("cameras")
    private List<Camera_> cameras = new ArrayList<Camera_>();
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
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The landingDate
     */
    @JsonProperty("landing_date")
    public String getLandingDate() {
        return landingDate;
    }

    /**
     *
     * @param landingDate
     * The landing_date
     */
    @JsonProperty("landing_date")
    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    /**
     *
     * @return
     * The maxSol
     */
    @JsonProperty("max_sol")
    public Integer getMaxSol() {
        return maxSol;
    }

    /**
     *
     * @param maxSol
     * The max_sol
     */
    @JsonProperty("max_sol")
    public void setMaxSol(Integer maxSol) {
        this.maxSol = maxSol;
    }

    /**
     *
     * @return
     * The maxDate
     */
    @JsonProperty("max_date")
    public String getMaxDate() {
        return maxDate;
    }

    /**
     *
     * @param maxDate
     * The max_date
     */
    @JsonProperty("max_date")
    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    /**
     *
     * @return
     * The totalPhotos
     */
    @JsonProperty("total_photos")
    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    /**
     *
     * @param totalPhotos
     * The total_photos
     */
    @JsonProperty("total_photos")
    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    /**
     *
     * @return
     * The cameras
     */
    @JsonProperty("cameras")
    public List<Camera_> getCameras() {
        return cameras;
    }

    /**
     *
     * @param cameras
     * The cameras
     */
    @JsonProperty("cameras")
    public void setCameras(List<Camera_> cameras) {
        this.cameras = cameras;
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
