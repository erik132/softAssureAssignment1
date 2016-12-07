import static org.junit.Assert.assertEquals;


import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.Ignore;
import org.junit.Test;

import com.google.java.contract.PreconditionError;
import com.google.java.contract.PostconditionError;
import com.google.java.contract.InvariantError;

//@Ignore
//@Test(expected = PreconditionError.class)
//@Test(expected = PostconditionError.class)

public class ProgramTest {

    //@Ignore
    @Test(expected = PreconditionError.class)
    public void test_minlength1() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setMinLength(3);
    }

    @Test(expected = PreconditionError.class)
    public void test_minlength2() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setMinLength(5);
    }

    //@Ignore
    @Test(expected = PreconditionError.class)
    public void test_maxlength() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setMaxLength(3);
    }

    @Test
    public void test_password() {
        PasswordCriteria cr = new PasswordCriteria();
        assertEquals(true, cr.isValid("aaaa"));
    }

    @Test
    public void test_mixedcase1() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasMixedCase(true);
        assertEquals(true, cr.isValid("aaZA"));
    }

    @Test
    public void test_mixedcase2() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasMixedCase(false);
        assertEquals(false, cr.isValid("aaZA"));
    }

    @Test
    public void test_numbers1() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
        cr.setHasLetters(false);
        assertEquals(true, cr.isValid("1221"));
    }

    @Test
    public void test_numbers2() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
        cr.setHasLetters(false);
        assertEquals(false, cr.isValid("abcd"));
    }

    @Test
    public void test_letters1() {
        PasswordCriteria cr = new PasswordCriteria();
        assertEquals(true, cr.isValid("abcd"));
    }

    @Test
    public void test_letters2() {
        PasswordCriteria cr = new PasswordCriteria();
        assertEquals(false, cr.isValid("1234"));
    }

    @Test
    public void test_alldifferent1() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasAllDifferent(true);
        assertEquals(true, cr.isValid("abcd"));
    }

    @Test
    public void test_alldifferent2() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasAllDifferent(true);
        assertEquals(false, cr.isValid("aabc"));
    }

    @Test
    public void test_set_numbers() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
    }

    @Test
    public void test_set_letters() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasLetters(true);
    }

    @Test (expected = InvariantError.class)
    public void test_set_letters_invariant() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasLetters(false);
    }

    @Test (expected = InvariantError.class)
    public void test_set_numbers_invariant() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
        cr.setHasLetters(false);
        cr.setHasNumbers(false);
    }

    @Test
    public void test_set_mixed() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasMixedCase(true);
    }

    @Test(expected = PreconditionError.class)
    public void test_password_null() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.isValid(null);
    }

    @Test(expected = PreconditionError.class)
    public void test_password_empty() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.isValid("");
    }

    @Test
    public void test_get_maxlength() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setMaxLength(10);
        assertEquals(new Integer(10), cr.getMaxLength());
    }

    @Test
    public void test_get_minlength() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setMaxLength(10);
        cr.setMinLength(5);
        assertEquals(new Integer(5), cr.getMinLength());
    }

    @Test
    public void test_get_letters() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
        cr.setHasLetters(false);
        assertEquals(false, cr.getHasLetters());
    }

    @Test
    public void test_get_numbers() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasNumbers(true);
        assertEquals(true, cr.getHasNumbers());
    }

    @Test
    public void test_get_mixed() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasMixedCase(true);
        assertEquals(true, cr.getHasMixedCase());
    }

    @Test
    public void test_get_alldifferent() {
        PasswordCriteria cr = new PasswordCriteria();
        cr.setHasAllDifferent(true);
        assertEquals(true, cr.getHasAllDifferent());
    }
}
