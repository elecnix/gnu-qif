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

import gnu.qif.RecordArray;
import gnu.qif.AccountRecord;
import gnu.qif.QIFRecord;
import gnu.qif.BankTransaction;
import gnu.qif.OpeningBalanceRecord;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.util.Date;

/**
 * <p>A sample usage of the gnu.qif package, used to show how to
 * transfer from "Second Account"'s "SecondAccountCategory"
 * into "First Account". The transaction is defined in the
 * "First Account" as a deposit.</p>
 *
 * <p>You can run this sample by first setting your CLASSPATH
 * so that it included the gnu.qif classes (maybe the jar file),
 * by compiling it ("javac Sample2.java"), and running it ("java Sample2").</p>
 *
 * @see gnu.qif
 *
 * @author <a href="mailto:nicolas@marchildon.net">Nicolas Marchildon</a>
 * @version $Id: Sample2.java,v 1.1 2001/11/17 07:29:07 nicolas Exp $
 */
public class Sample2 {

    public static void main(String[] args) throws Exception {
        
        RecordArray records = new RecordArray();

        String firstAccountName = "First account";
        String secondAccountName = "Second account";
        
        /* First, we define the firstAccount */
        AccountRecord firstAccount = new AccountRecord(firstAccountName);
        records.addRecord(firstAccount);

        /* This means we deposit 2$ into firstAccount,
           from SecondAccountCategory of secondAccount */
        BankTransaction tr = new BankTransaction();
        tr.setNumber("1");
        tr.setTotal(2); // Deposit if positive, withdrawal when negative
        tr.setDate(new Date());
        tr.setMemo("Memo1");
        tr.setPayee("Payee1");
        tr.setAccount(secondAccountName);
        tr.setCategory("SecondAccountCategory");
        records.addRecord(tr);

        System.out.println(records.toString());
    }
    
}
