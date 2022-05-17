package io.javaCode.IPLDashboard.data;

import java.time.LocalDateTime;
import io.javaCode.IPLDashboard.Model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchProcessor.class);

    Match match = new Match();

    @Override
    public Match process(final MatchInput matchInput) throws Exception {


        // match.setId(long.parseLong(matchInput.getId())));
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());

        match.setDate(LocalDateTime.parse(matchInput.getDate()));
        //match.setDate(LocatDateTime.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());


        String firstInningsTeam, secondInningsTeam;

        if ("bat".equals(matchInput.getToss_decision())) {
            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
                    matchInput.getTeam2() : matchInput.getTeam1();

        } else {
            secondInningsTeam = matchInput.getToss_winner();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
                    matchInput.getTeam2() : matchInput.getTeam1();
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);

        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());


        return match;


//        final String firstName = person.getFirstName().toUpperCase();
//        final String lastName = person.getLastName().toUpperCase();
//
//        final Person transformedPerson = new Person(firstName, lastName);


    }
}


