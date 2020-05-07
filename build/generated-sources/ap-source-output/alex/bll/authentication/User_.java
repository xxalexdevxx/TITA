package alex.bll.authentication;

import alex.bll.issues.Issue;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-07T15:28:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> zipcode;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Long> userId;
    public static volatile ListAttribute<User, Issue> issues;
    public static volatile SingularAttribute<User, String> email;

}