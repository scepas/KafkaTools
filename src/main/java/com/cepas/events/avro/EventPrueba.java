/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cepas.events.avro;  
@SuppressWarnings("all")
/** Evento avro de prueba */
@org.apache.avro.specific.AvroGenerated
public class EventPrueba extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventPrueba\",\"namespace\":\"com.cepas.events.avro\",\"doc\":\"Evento avro de prueba\",\"fields\":[{\"name\":\"nombre\",\"type\":\"string\"},{\"name\":\"edad\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence nombre;
  @Deprecated public int edad;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EventPrueba() {}

  /**
   * All-args constructor.
   */
  public EventPrueba(java.lang.CharSequence nombre, java.lang.Integer edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return nombre;
    case 1: return edad;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: nombre = (java.lang.CharSequence)value$; break;
    case 1: edad = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'nombre' field.
   */
  public java.lang.CharSequence getNombre() {
    return nombre;
  }

  /**
   * Sets the value of the 'nombre' field.
   * @param value the value to set.
   */
  public void setNombre(java.lang.CharSequence value) {
    this.nombre = value;
  }

  /**
   * Gets the value of the 'edad' field.
   */
  public java.lang.Integer getEdad() {
    return edad;
  }

  /**
   * Sets the value of the 'edad' field.
   * @param value the value to set.
   */
  public void setEdad(java.lang.Integer value) {
    this.edad = value;
  }

  /** Creates a new EventPrueba RecordBuilder */
  public static com.cepas.events.avro.EventPrueba.Builder newBuilder() {
    return new com.cepas.events.avro.EventPrueba.Builder();
  }
  
  /** Creates a new EventPrueba RecordBuilder by copying an existing Builder */
  public static com.cepas.events.avro.EventPrueba.Builder newBuilder(com.cepas.events.avro.EventPrueba.Builder other) {
    return new com.cepas.events.avro.EventPrueba.Builder(other);
  }
  
  /** Creates a new EventPrueba RecordBuilder by copying an existing EventPrueba instance */
  public static com.cepas.events.avro.EventPrueba.Builder newBuilder(com.cepas.events.avro.EventPrueba other) {
    return new com.cepas.events.avro.EventPrueba.Builder(other);
  }
  
  /**
   * RecordBuilder for EventPrueba instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventPrueba>
    implements org.apache.avro.data.RecordBuilder<EventPrueba> {

    private java.lang.CharSequence nombre;
    private int edad;

    /** Creates a new Builder */
    private Builder() {
      super(com.cepas.events.avro.EventPrueba.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cepas.events.avro.EventPrueba.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.nombre)) {
        this.nombre = data().deepCopy(fields()[0].schema(), other.nombre);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.edad)) {
        this.edad = data().deepCopy(fields()[1].schema(), other.edad);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EventPrueba instance */
    private Builder(com.cepas.events.avro.EventPrueba other) {
            super(com.cepas.events.avro.EventPrueba.SCHEMA$);
      if (isValidValue(fields()[0], other.nombre)) {
        this.nombre = data().deepCopy(fields()[0].schema(), other.nombre);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.edad)) {
        this.edad = data().deepCopy(fields()[1].schema(), other.edad);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'nombre' field */
    public java.lang.CharSequence getNombre() {
      return nombre;
    }
    
    /** Sets the value of the 'nombre' field */
    public com.cepas.events.avro.EventPrueba.Builder setNombre(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.nombre = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'nombre' field has been set */
    public boolean hasNombre() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'nombre' field */
    public com.cepas.events.avro.EventPrueba.Builder clearNombre() {
      nombre = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'edad' field */
    public java.lang.Integer getEdad() {
      return edad;
    }
    
    /** Sets the value of the 'edad' field */
    public com.cepas.events.avro.EventPrueba.Builder setEdad(int value) {
      validate(fields()[1], value);
      this.edad = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'edad' field has been set */
    public boolean hasEdad() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'edad' field */
    public com.cepas.events.avro.EventPrueba.Builder clearEdad() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public EventPrueba build() {
      try {
        EventPrueba record = new EventPrueba();
        record.nombre = fieldSetFlags()[0] ? this.nombre : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.edad = fieldSetFlags()[1] ? this.edad : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
