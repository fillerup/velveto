package nl.velveto;

import nl.velveto.domain.AuctionDataStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@EnableAutoConfiguration
public class HelloVelveto {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public static void main(String[] args) {
        SpringApplication.run(HelloVelveto.class);
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.
        AuctionDataStatus ahStatus = restTemplate.getForObject("http://eu.battle.net/api/wow/auction/data/arathor", AuctionDataStatus.class);
        System.out.println("Url:    " + ahStatus.getUrl());
        System.out.println("lastModified:   " + dateFormat.format(ahStatus.getLastModified()));
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

}

