 package io.javaCode.IPLDashboard;

 import io.javaCode.IPLDashboard.data.MatchInput;
 import io.javaCode.IPLDashboard.Model.Match;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.batch.item.ItemProcessor;

 import java.time.LocalDate;
 import java.time.LocalDateTime;

 public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>
 {

        private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

        @Override
        public Match process(final MatchInput matchInput) throws Exception
        {
            Match match=new Match();

            match.setId(Long.parseLong(matchInput.getId()));
            match.setCity(matchInput.getCity());
            match.setDate(LocalDate.parse(matchInput.getDate()));
            match.setPlayerOfMatch(matchInput.getPlayer_of_match());
//            match.setEliminator(matchInput.getEliminator());
           match.setVenue(matchInput.getVenue());

           String firstInningTeam,secondInningTeam;

           if("bat" .equals(matchInput.getToss_decision()))
            {
                firstInningTeam= matchInput.getToss_winner();
                secondInningTeam= matchInput.getToss_winner().equals(matchInput.getTeam1())
                ? matchInput.getTeam2():matchInput.getTeam1();
            }
           else
           {
               secondInningTeam= matchInput.getToss_winner();
               firstInningTeam=matchInput.getToss_winner().equals(matchInput.getTeam2())
                       ? matchInput.getTeam1():matchInput.getTeam2();
           }
           match.setTeam1(firstInningTeam);
           match.setTeam2(secondInningTeam);



//            final MatchInput transformedPerson = new Person(firstName, lastName);
//

            return match;
        }

    }
}
