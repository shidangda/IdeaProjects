/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/**
 * Provides utility classes to allow serializable mappings between SQL types
 * and data types in the Java programming language.
 * <p> Standard JDBC <code>RowSet</code> implementations may use these utility
 * classes to
 * assist in the serialization of disconnected <code>RowSet</code> objects.
 * This is useful
 * when  transmitting a disconnected <code>RowSet</code> object over the wire to
 * a different VM or across layers within an application.<br>
 * </p>
 *
 * <h3>1.0 SerialArray</h3>
 * A serializable mapping in the Java programming language of an SQL ARRAY
 * value. <br>
 * <br>
 * The <code>SerialArray</code> class provides a constructor for creating a <code>SerialArray</code>
 * instance from an Array object, methods for getting the base type and
 * the SQL name for the base type, and methods for copying all or part of a
 * <code>SerialArray</code> object. <br>
 *
 * <h3>2.0 SerialBlob</h3>
 * A serializable mapping in the Java programming language of an SQL BLOB
 * value.  <br>
 * <br>
 * The <code>SerialBlob</code>class provides a constructor for creating an instance
 * from a Blob object. Note that the Blob object should have brought the SQL
 * BLOB value's data over to the client before a <code>SerialBlob</code>object
 * is constructed from it. The data of an SQL BLOB value can be materialized
 * on the client as an array of bytes (using the method <code>Blob.getBytes</code>)
 * or as a stream of uninterpreted bytes (using the method <code>Blob.getBinaryStream</code>).
 * <br>
 * <br>
 * <code>SerialBlob</code> methods make it possible to make a copy of a <code>SerialBlob</code>
 * object as an array of bytes or as a stream. They also make it possible
 * to locate a given pattern of bytes or a <code>Blob</code> object within a <code>SerialBlob</code>
 * object. <br>
 *
 * <h3>3.0 SerialClob</h3>
 * A serializable mapping in the Java programming language of an SQL CLOB
 * value.  <br>
 * <br>
 * The <code>SerialClob</code> class provides a constructor for creating an instance
 * from a <code>Clob</code> object. Note that the <code>Clob</code> object should have
 * brought the SQL CLOB value's data over to the client before a <code>SerialClob</code>
 * object is constructed from it. The data of an SQL CLOB value can be
 * materialized on the client as a stream of Unicode characters. <br>
 * <br>
 * <code>SerialClob</code> methods make it possible to get a substring from a
 * <code>SerialClob</code> object or to locate the start of a pattern of characters.
 * <br>
 *
 * <h3>5.0 SerialDatalink</h3>
 * A serializable mapping in the Java programming language of an SQL DATALINK
 * value. A DATALINK value references a file outside of the underlying data source
 * that the originating data source manages. <br>
 * <br>
 * <code>RowSet</code> implementations can use the method <code>RowSet.getURL()</code> to retrieve
 * a <code>java.net.URL</code> object, which can be used to manipulate the external data.
 * <br>
 * <br>
 * &nbsp;&nbsp;<code>&nbsp;&nbsp;&nbsp; java.net.URL url = rowset.getURL(1);</code><br>
 *
 * <h3>6.0 SerialJavaObject</h3>
 * A serializable mapping in the Java programming language of an SQL JAVA_OBJECT
 * value. Assuming the Java object instance implements the Serializable interface,
 * this simply wraps the serialization process. <br>
 * <br>
 * If however, the serialization is not possible in the case where the Java
 * object is not immediately serializable, this class will attempt to serialize
 * all non static members to permit the object instance state to be serialized.
 * Static or transient fields cannot be serialized and attempting to do so
 * will result in a <code>SerialException</code> being thrown. <br>
 *
 * <h3>7.0 SerialRef</h3>
 * A serializable mapping between the SQL REF type and the Java programming
 * language. <br>
 * <br>
 * The <code>SerialRef</code> class provides a constructor for creating a <code>SerialRef</code>
 * instance from a <code>Ref</code> type and provides methods for getting
 * and setting the <code>Ref</code> object type. <br>
 *
 * <h3>8.0 SerialStruct</h3>
 * A serializable mapping in the Java programming language of an SQL structured
 * type. Each attribute that is not already serializable is mapped to a serializable
 * form, and if an attribute is itself a structured type, each of its attributes
 * that is not already serializable is mapped to a serializable form. <br>
 * <br>
 * In addition, if a <code>Map</code> object is passed to one of the constructors or
 * to the method <code>getAttributes</code>, the structured type is custom mapped
 * according to the mapping specified in the <code>Map</code> object.
 * <br>
 * The <code>SerialStruct</code> class provides a constructor for creating an
 * instance  from a <code>Struct</code> object, a method for retrieving the SQL
 * type name of the SQL structured type in the database, and methods for retrieving
 * its attribute values. <br>
 *
 * <h3>9.0 SQLInputImpl</h3>
 *   An input stream used for custom mapping user-defined types (UDTs). An
 *   <code>SQLInputImpl</code> object is an input stream that contains a stream of
 *   values that are
 * the attributes of a UDT. This class is used by the driver behind the scenes
 * when the method <code>getObject</code> is called on an SQL structured or distinct
 * type that has a custom mapping; a programmer never invokes <code>SQLInputImpl</code>
 * methods directly. <br>
 *   <br>
 * The <code>SQLInputImpl</code> class provides a set of reader methods
 * analogous to the <code>ResultSet</code> getter methods. These methods make it
 * possible to read the values in an <code>SQLInputImpl</code> object. The method
 * <code>wasNull</code> is used to determine whether the last value read was SQL NULL.
 * <br>
 *  <br>
 * When a constructor or getter method that takes a <code>Map</code> object is called,
 * the JDBC driver calls the method
 * <code>SQLData.getSQLType</code> to determine the SQL type of the UDT being custom
 * mapped. The driver  creates an instance of <code>SQLInputImpl</code>, populating it with
 * the attributes of  the UDT. The driver then passes the input stream to the
 * method <code>SQLData.readSQL</code>,  which in turn calls the <code>SQLInputImpl</code>
 * methods to read the  attributes from the input stream. <br>
 *
 * <h3>10.0 SQLOutputImpl</h3>
 *   The output stream for writing the attributes of a custom mapped user-defined
 *  type (UDT) back to the database. The driver uses this interface internally,
 *  and its methods are never directly invoked by an application programmer.
 * <br>
 *   <br>
 * When an application calls the method <code>PreparedStatement.setObject</code>, the
 * driver checks to see whether the value to be written is a UDT with a custom
 * mapping. If it is, there will be an entry in a type map containing the Class
 * object for the class that implements <code>SQLData</code> for this UDT. If the
 * value to be written is an instance of <code>SQLData</code>, the driver will
 * create  an instance of <code>SQLOutputImpl</code> and pass it to the method
 * <code>SQLData.writeSQL</code>.
 * The method <code>writeSQL</code> in turn calls the appropriate <code>SQLOutputImpl</code>
 * writer methods to write data from the <code>SQLData</code> object to the
 * <code>SQLOutputImpl</code>
 * output  stream as the representation of an SQL user-defined type.
 *
 * <h3>Custom Mapping</h3>
 * The JDBC API provides mechanisms for mapping an SQL structured type or DISTINCT
 * type to the Java programming language.  Typically, a structured type is mapped
 * to a class, and its attributes are mapped to fields in the class.
 * (A DISTINCT type can thought of as having one attribute.)  However, there are
 * many other possibilities, and there may be any number of different mappings.
 * <P>
 * A programmer defines the mapping by implementing the interface <code>SQLData</code>.
 * For example, if an SQL structured type named AUTHORS has the attributes NAME,
 * TITLE, and PUBLISHER, it could be mapped to a Java class named Authors.  The
 * Authors class could have the fields name, title, and publisher, to which the
 * attributes of AUTHORS are mapped.  In such a case, the implementation of
 * <code>SQLData</code> could look like the following:
 * <PRE>
 *    public class Authors implements SQLData {
 *        public String name;
 *        public String title;
 *        public String publisher;
 *
 *        private String sql_type;
 *        public String getSQLTypeName() {
 *            return sql_type;
 *        }
 *
 *        public void readSQL(SQLInput stream, String type)
 *                                   throws SQLException  {
 *            sql_type = type;
 *            name = stream.readString();
 *            title = stream.readString();
 *            publisher = stream.readString();
 *        }
 *
 *        public void writeSQL(SQLOutput stream) throws SQLException {
 *            stream.writeString(name);
 *            stream.writeString(title);
 *            stream.writeString(publisher);
 *        }
 *    }
 * </PRE>
 *
 * A <code>java.util.Map</code> object is used to associate the SQL structured
 * type with its mapping to the class <code>Authors</code>. The following code fragment shows
 * how a <code>Map</code> object might be created and given an entry associating
 * <code>AUTHORS</code> and <code>Authors</code>.
 * <PRE>
 *     java.util.Map map = new java.util.HashMap();
 *     map.put("SCHEMA_NAME.AUTHORS", Class.forName("Authors");
 * </PRE>
 *
 * The <code>Map</code> object <i>map</i> now contains an entry with the
 * fully qualified name of the SQL structured type and the <code>Class</code>
 *  object for the class <code>Authors</code>.  It can be passed to a method
 * to tell the driver how to map <code>AUTHORS</code> to <code>Authors</code>.
 * <P>
 * For a disconnected <code>RowSet</code> object, custom mapping can be done
 * only when a <code>Map</code> object is passed to the method or constructor
 * that will be doing the custom mapping.  The situation is different for
 * connected <code>RowSet</code> objects because they maintain a connection
 * with the data source.  A method that does custom mapping and is called by
 * a disconnected <code>RowSet</code> object may use the <code>Map</code>
 * object that is associated with the <code>Connection</code> object being
 * used. So, in other words, if no map is specified, the connection's type
 * map can be used by default.
 */
package javax.sql.rowset.serial;
