package nl.velveto.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuctionDataStatus {


    public String url;
    public Date lastModified;

    @JsonCreator
    public AuctionDataStatus(Map<String,Object> props)
    {
        Map nestedProps = (Map)((ArrayList)props.get("files")).get(0);
        url = (String)nestedProps.get("url");
        lastModified = new Date((Long)nestedProps.get("lastModified"));
    }

    public String getUrl() {
        return url;
    }

    public Date getLastModified() {
        return lastModified;
    }
}
