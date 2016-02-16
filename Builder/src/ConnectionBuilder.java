public interface ConnectionBuilder {

    public void buildProperties();

    public void buildConfiguration();

    public HibernateConnection getHibernateConnection();

}
