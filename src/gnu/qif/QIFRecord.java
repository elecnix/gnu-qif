/*
The gnu.qif package: A tool for creating QIF files.
Copyright (C) 2001  Nicolas Marchildon

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package gnu.qif;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * <p>A <i>Quicken interchange format</i> record, which starts with
 * a <code>!Type:</code> or <code>!Account</code> header, and ends
 * with the <code>^</code> character.</p>
 *
 * <p>A record could look like this:</p>
 *
 * <p>
 * <pre>
 * !Type:Bank
 * D16/10/2001
 * T-10.0
 * N2
 * PMy first expense
 * LMy expenses
 * ^
 * </pre>
 * </p>
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: QIFRecord.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public abstract class QIFRecord {

    /** Bank account transactions */
    public static final String TYPE_BANK = "Bank";
    
    /** Cash account transactions */
    public static final String TYPE_CASH = "Cash";
    
    /** Credit card account transactions */
    public static final String TYPE_CREDIT_CARD = "CCard";
    
    /** Investment account transactions */
    public static final String TYPE_INVESTMENT = "Invst";
    
    /** Asset account transactions */
    public static final String TYPE_ASSET = "Oth A";
    
    /** Liability account transactions */
    public static final String TYPE_LIABILITY = "Oth L";
    
    /** Category list */
    public static final String TYPE_CATEGORY_LIST = "Cat";
    
    /** Class list */
    public static final String TYPE_CLASS_LIST = "Class";
    
    /** Memorized transaction list  */
    public static final String TYPE_MEMORIZED = "Memorized";
    

    public static final String RECORD_START = "!";
    public static final String RECORD_ACCOUNT = "Account";
    public static final String RECORD_TYPE = "Type";
    public static final String RECORD_END = "^";

    protected static String encodeDate(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return "" + cal.get(Calendar.DATE)
                + "/" + (cal.get(Calendar.MONTH) + 1)
                + "/" + cal.get(Calendar.YEAR);
    }

}
