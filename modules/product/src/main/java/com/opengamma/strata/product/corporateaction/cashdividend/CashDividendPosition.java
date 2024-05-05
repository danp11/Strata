package com.opengamma.strata.product.corporateaction.cashdividend;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.product.*;
import com.opengamma.strata.product.common.SummarizerUtils;
import org.joda.beans.*;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import org.joda.beans.Bean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;



@BeanDefinition(constructorScope = "package", factoryName = "of")
public final class CashDividendPosition
    implements SecuritizedProductPosition<CashDividend>, ImmutableBean, Serializable {


    /**
     * The additional position information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the position.
     */
    @PropertyDefinition(validate = "notNull", overrideGet = true)
    private final PositionInfo info;
    /**
     * The bill that was traded.
     * <p>
     * The product captures the contracted financial details.
     */
    @PropertyDefinition(validate = "notNull", overrideGet = true)
    private final CashDividend product;
    /**
     * The long quantity of the security.
     * <p>
     * This is the quantity of the underlying security that is held.
     * The quantity cannot be negative, as that would imply short selling.
     */
    @PropertyDefinition(validate = "ArgChecker.notNegative")
    private final double quantity;




    //-------------------------------------------------------------------------
    @Override
    public SecurityId getSecurityId() {
        return product.getSecurityId();
    }

    @Override
    public Currency getCurrency() {
        return product.getCurrency();
    }



    //-------------------------------------------------------------------------
    @Override
    public CashDividendPosition withInfo(PortfolioItemInfo info) {
        return new CashDividendPosition(PositionInfo.from(info), product, quantity);
    }

    @Override
    public CashDividendPosition withQuantity(double quantity) {
        return new CashDividendPosition(info, product, quantity);
    }

    //-------------------------------------------------------------------------
    @Override
    public PortfolioItemSummary summarize() {
        // ID x 200
        String description = getSecurityId().getStandardId().getValue() + " x " + SummarizerUtils.value(getQuantity());
        return SummarizerUtils.summary(this, ProductType.OTHER, description);
    }
  //------------------------- AUTOGENERATED START -------------------------
  /**
   * The meta-bean for {@code CashDividendPosition}.
   * @return the meta-bean, not null
   */
  public static CashDividendPosition.Meta meta() {
    return CashDividendPosition.Meta.INSTANCE;
  }

  static {
    MetaBean.register(CashDividendPosition.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Obtains an instance.
   * @param info  the value of the property, not null
   * @param product  the value of the property, not null
   * @param quantity  the value of the property
   * @return the instance
   */
  public static CashDividendPosition of(
      PositionInfo info,
      CashDividend product,
      double quantity) {
    return new CashDividendPosition(
      info,
      product,
      quantity);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CashDividendPosition.Builder builder() {
    return new CashDividendPosition.Builder();
  }

  /**
   * Creates an instance.
   * @param info  the value of the property, not null
   * @param product  the value of the property, not null
   * @param quantity  the value of the property
   */
  CashDividendPosition(
      PositionInfo info,
      CashDividend product,
      double quantity) {
    JodaBeanUtils.notNull(info, "info");
    JodaBeanUtils.notNull(product, "product");
    ArgChecker.notNegative(quantity, "quantity");
    this.info = info;
    this.product = product;
    this.quantity = quantity;
  }

  @Override
  public CashDividendPosition.Meta metaBean() {
    return CashDividendPosition.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the additional position information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the position.
   * @return the value of the property, not null
   */
  @Override
  public PositionInfo getInfo() {
    return info;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the bill that was traded.
   * <p>
   * The product captures the contracted financial details.
   * @return the value of the property, not null
   */
  @Override
  public CashDividend getProduct() {
    return product;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the long quantity of the security.
   * <p>
   * This is the quantity of the underlying security that is held.
   * The quantity cannot be negative, as that would imply short selling.
   * @return the value of the property
   */
  public double getQuantity() {
    return quantity;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CashDividendPosition other = (CashDividendPosition) obj;
      return JodaBeanUtils.equal(info, other.info) &&
          JodaBeanUtils.equal(product, other.product) &&
          JodaBeanUtils.equal(quantity, other.quantity);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(info);
    hash = hash * 31 + JodaBeanUtils.hashCode(product);
    hash = hash * 31 + JodaBeanUtils.hashCode(quantity);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("CashDividendPosition{");
    buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
    buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
    buf.append("quantity").append('=').append(JodaBeanUtils.toString(quantity));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CashDividendPosition}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code info} property.
     */
    private final MetaProperty<PositionInfo> info = DirectMetaProperty.ofImmutable(
        this, "info", CashDividendPosition.class, PositionInfo.class);
    /**
     * The meta-property for the {@code product} property.
     */
    private final MetaProperty<CashDividend> product = DirectMetaProperty.ofImmutable(
        this, "product", CashDividendPosition.class, CashDividend.class);
    /**
     * The meta-property for the {@code quantity} property.
     */
    private final MetaProperty<Double> quantity = DirectMetaProperty.ofImmutable(
        this, "quantity", CashDividendPosition.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "info",
        "product",
        "quantity");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case -1285004149:  // quantity
          return quantity;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CashDividendPosition.Builder builder() {
      return new CashDividendPosition.Builder();
    }

    @Override
    public Class<? extends CashDividendPosition> beanType() {
      return CashDividendPosition.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code info} property.
     * @return the meta-property, not null
     */
    public MetaProperty<PositionInfo> info() {
      return info;
    }

    /**
     * The meta-property for the {@code product} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CashDividend> product() {
      return product;
    }

    /**
     * The meta-property for the {@code quantity} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> quantity() {
      return quantity;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return ((CashDividendPosition) bean).getInfo();
        case -309474065:  // product
          return ((CashDividendPosition) bean).getProduct();
        case -1285004149:  // quantity
          return ((CashDividendPosition) bean).getQuantity();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CashDividendPosition}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CashDividendPosition> {

    private PositionInfo info;
    private CashDividend product;
    private double quantity;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CashDividendPosition beanToCopy) {
      this.info = beanToCopy.getInfo();
      this.product = beanToCopy.getProduct();
      this.quantity = beanToCopy.getQuantity();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          return info;
        case -309474065:  // product
          return product;
        case -1285004149:  // quantity
          return quantity;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 3237038:  // info
          this.info = (PositionInfo) newValue;
          break;
        case -309474065:  // product
          this.product = (CashDividend) newValue;
          break;
        case -1285004149:  // quantity
          this.quantity = (Double) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public CashDividendPosition build() {
      return new CashDividendPosition(
          info,
          product,
          quantity);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the additional position information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the position.
     * @param info  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder info(PositionInfo info) {
      JodaBeanUtils.notNull(info, "info");
      this.info = info;
      return this;
    }

    /**
     * Sets the bill that was traded.
     * <p>
     * The product captures the contracted financial details.
     * @param product  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder product(CashDividend product) {
      JodaBeanUtils.notNull(product, "product");
      this.product = product;
      return this;
    }

    /**
     * Sets the long quantity of the security.
     * <p>
     * This is the quantity of the underlying security that is held.
     * The quantity cannot be negative, as that would imply short selling.
     * @param quantity  the new value
     * @return this, for chaining, not null
     */
    public Builder quantity(double quantity) {
      ArgChecker.notNegative(quantity, "quantity");
      this.quantity = quantity;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("CashDividendPosition.Builder{");
      buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
      buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
      buf.append("quantity").append('=').append(JodaBeanUtils.toString(quantity));
      buf.append('}');
      return buf.toString();
    }

  }

  //-------------------------- AUTOGENERATED END --------------------------
}