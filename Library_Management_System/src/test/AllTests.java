package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AuthorTest.class, BookLoanTest.class, BookTest.class, BorrowerTest.class, BranchTest.class, GenreTest.class, PublisherTest.class})
public class AllTests {

}
