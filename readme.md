1. 什么是jdbctemplate
	对jdbc进行了封装，方便对DB进行增删改查的操作
2. 配置连接池
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/user_db"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    </bean>
3. 配置jdbctemplate对象 
<!--jdbctemplate对象-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <!--注入属性-->
        <property name="dataSource" ref="dataSource"/>
    </bean>
4.创建service dao类，dao注入jdbctemplate对象进行操作 
service 
@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;
    //添加
    public void add(Book book){
        bookDao.add(book);
    }
    //修改
    public void update(Book book){
        bookDao.update(book);
    }
dao 

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //添加
    @Override
    public void add(Book book) {
        String sql = "INSERT INTO t_book VALUES(?,?,?)";
        Object [] args = {book.getUserId(),book.getUserName(),book.getUstatus()};
        int result = jdbcTemplate.update(sql,args);
        System.out.println(result);}
5.增删改查操作大都一致
