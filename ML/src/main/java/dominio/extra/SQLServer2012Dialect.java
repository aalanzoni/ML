/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.extra;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.type.IntegerType;
import org.hibernate.type.TimestampType;

/**
 *
 * @author Andres Lanzoni
 */
public class SQLServer2012Dialect extends SQLServerDialect{
   private static final int MAX_LENGTH = 8000;

   /**
    * Initializes a new instance of the {@link SQLServerDialect} class.
    */
   public SQLServer2012Dialect() {
      // SQL Server 2005 Dialect
      // HHH-3965 fix
      // As per http://www.sql-server-helper.com/faq/sql-server-2005-varchar-max-p01.aspx
      // use varchar(max) and varbinary(max) instead of TEXT and IMAGE types
      registerColumnType(Types.BLOB, "varbinary(MAX)");
      registerColumnType(Types.VARBINARY, "varbinary(MAX)");
      registerColumnType(Types.VARBINARY, MAX_LENGTH, "varbinary($l)");
      registerColumnType(Types.LONGVARBINARY, "varbinary(MAX)");

      registerColumnType(Types.CLOB, "varchar(MAX)");
      registerColumnType(Types.LONGVARCHAR, "varchar(MAX)");
      registerColumnType(Types.VARCHAR, "varchar(MAX)");
      registerColumnType(Types.VARCHAR, MAX_LENGTH, "varchar($l)");

//      registerColumnType(Types.BIGINT, "bigint");
//      registerColumnType(Types.BIT, "bit");

      registerFunction("row_number", new NoArgSQLFunction("row_number", new IntegerType(), true));

      // SQL Server 2008
      registerColumnType(Types.DATE, "date");
      registerColumnType(Types.TIME, "time");
      registerColumnType(Types.TIMESTAMP, "datetime2");

      registerFunction("current_timestamp", new NoArgSQLFunction("current_timestamp", new TimestampType(), false));
   }    
}
