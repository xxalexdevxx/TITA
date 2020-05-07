package alex.bll.issues;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-07T15:28:54")
@StaticMetamodel(Issue.class)
public class Issue_ { 

    public static volatile SingularAttribute<Issue, Date> issueCreatedDate;
    public static volatile SingularAttribute<Issue, String> issueStatus;
    public static volatile SingularAttribute<Issue, Long> issueId;
    public static volatile SingularAttribute<Issue, String> issueSummary;
    public static volatile SingularAttribute<Issue, Integer> estimatedEffort;
    public static volatile SingularAttribute<Issue, String> estimatedCompletionDate;

}