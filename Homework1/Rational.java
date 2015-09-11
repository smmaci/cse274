/**
 * A class that represents a rational number. 
 * @author Ch. H.  Modified by H. W. A 
*/

/*
*Samuel Mallamaci
*mallamsg
*CSE274 Section C
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE
	private int numerator;
	private int denominator;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        // ADD CODE TO THE CONSTRUCTOR
    	numerator = 1;
    	denominator = 1;
    	
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
        // ADD CODE TO THE ALTERNATE CONSTRUCTOR
    	numerator = n;
    	if(d == 0){
    		ZeroDenominatorException zde = new ZeroDenominatorException("Denominator cannot be zero");
    		throw zde;
    	}
    	else{
    		denominator = d;
    	}
    	normalize(this);
    	
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return numerator;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return denominator;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {       
    	return new Rational(this.getNumerator() * -1, this.getDenominator());
        
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	int invDen = this.getNumerator();
    	int invNum = this.getDenominator();
    	return new Rational(invNum, invDen);
    }



    /**
     * Add two rational numbers
     *
     * @param other the second argument of the a
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	int newNumerator = this.getNumerator() * other.getDenominator() + other.getNumerator()*this.getDenominator();
    	int newDenominator = this.getDenominator()*other.getDenominator();
    	Rational temp = new Rational(newNumerator, newDenominator);
        return temp;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	int newNumerator = this.getNumerator() * other.getDenominator() - other.getNumerator()*this.getDenominator();
    	int newDenominator = this.getDenominator()*other.getDenominator();
    	Rational temp = new Rational(newNumerator, newDenominator);
        return temp;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	Rational temp = new Rational(this.getNumerator() * other.getNumerator() , this.getDenominator() * other.getDenominator());
        return temp;
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	Rational temp = new Rational(this.getNumerator() * other.getDenominator() , this.getDenominator() * other.getNumerator());
        return temp;
    }
     
 
 
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize(Rational r)
    {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER
    	int newNumerator = r.getNumerator();
    	int newDenominator = r.getDenominator();
        boolean negative;
        negative = ((newNumerator < 0 && newDenominator > 0) || (newNumerator > 0 && newDenominator < 0));
        //This finds if the rational number should be positive or negative. This will become relevant.
    	if(newNumerator < 0){
    		//We have to make the rational positive before sending it to the gcd function so that the function
    		//does not get stuck in a recursive loop.
    		newNumerator *= -1;
    	}
    	if(newDenominator < 0){
    		newDenominator *= -1;
    	}
    	
    	int myGcd = gcd(newNumerator, newDenominator);
    	newNumerator /= myGcd;
    	newDenominator /= myGcd;
    	
        if(negative){
        	//Now that the rational number has been reduced, we can reassign the negative value.
        	newNumerator *= -1;
        }
    	numerator = newNumerator;
    	denominator = newDenominator;
    }
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
