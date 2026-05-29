# Shopping Cart Application - Complete Setup Guide

## Project Overview
A comprehensive Java-based e-commerce shopping cart application with:
- User authentication (customer & admin roles)
- Product catalog with search/filter
- Shopping cart management
- Order processing with payment integration
- Admin order management with tracking
- Product reviews and ratings
- Order status tracking

## Technology Stack
- **Backend:** Java, Jakarta Servlet, JSP
- **Database:** MySQL
- **Payment:** Razorpay Integration
- **Server:** Apache Tomcat

## Prerequisites
- Java JDK 11 or higher
- MySQL Server 5.7 or higher
- Apache Tomcat 10.x or higher
- Maven 3.6+

## Database Setup

1. **Create Database:**
   ```sql
   CREATE DATABASE IF NOT EXISTS shoppingcart;
   USE shoppingcart;
   ```

2. **Execute SQL Schema:**
   - Import `database_schema.sql` file into MySQL
   - This creates all tables with sample data
   - Admin user created: `admin@example.com` / `admin123`

3. **Verify Tables:**
   ```sql
   SHOW TABLES;
   ```

## Project Structure

```
ShoppingCartApp/
├── src/
│   └── main/
│       ├── java/com/
│       │   ├── aspect/
│       │   │   ├── ConnectionProvider.java    (Database connection)
│       │   │   └── ObjectCreater.java         (Object factory)
│       │   ├── bean/
│       │   │   ├── User.java
│       │   │   ├── Product.java
│       │   │   ├── CartItem.java
│       │   │   ├── Order.java
│       │   │   ├── Payment.java
│       │   │   └── Review.java                (NEW)
│       │   ├── controller/
│       │   │   ├── LoginServlet.java
│       │   │   ├── RegistrationServlet.java
│       │   │   ├── ProductServlet.java
│       │   │   ├── CartServlet.java
│       │   │   ├── CheckoutServlet.java       (NEW)
│       │   │   ├── OrdersServlet.java
│       │   │   ├── PaymentServlet.java
│       │   │   ├── RazorpayCreateOrderServlet.java
│       │   │   ├── RazorpayVerifyServlet.java
│       │   │   ├── ReviewServlet.java         (NEW)
│       │   │   └── AdminServlet.java
│       │   ├── DAO/
│       │   │   ├── UserDAO.java
│       │   │   ├── ProductDAO.java
│       │   │   ├── CartDAO.java
│       │   │   ├── OrderDAO.java
│       │   │   ├── PaymentDAO.java
│       │   │   └── ReviewDAO.java             (NEW)
│       │   ├── DAOImpl/
│       │   │   ├── UserDAOImpl.java
│       │   │   ├── ProductDAOImpl.java
│       │   │   ├── CartDAOImpl.java
│       │   │   ├── OrderDAOImpl.java
│       │   │   ├── PaymentDAOImpl.java
│       │   │   └── ReviewDAOImpl.java          (NEW)
│       │   ├── services/
│       │   │   ├── UserService.java
│       │   │   ├── ProductService.java
│       │   │   ├── CartService.java
│       │   │   ├── OrderService.java
│       │   │   ├── PaymentService.java
│       │   │   └── ReviewService.java         (NEW)
│       │   └── serviceimpl/
│       │       ├── UserServiceImpl.java
│       │       ├── ProductServiceImpl.java
│       │       ├── CartServiceImpl.java
│       │       ├── OrderServiceImpl.java
│       │       ├── PaymentServiceImpl.java
│       │       └── ReviewServiceImpl.java      (NEW)
│       ├── webapp/
│       │   ├── index.jsp
│       │   ├── login.jsp
│       │   ├── register.jsp
│       │   ├── productList.jsp
│       │   ├── cart.jsp
│       │   ├── checkout.jsp                   (ENHANCED)
│       │   ├── orderConfirmation.jsp          (ENHANCED)
│       │   ├── orders.jsp
│       │   ├── payment.jsp
│       │   ├── reviewList.jsp                 (NEW)
│       │   ├── adminDashboard.jsp
│       │   ├── adminOrders.jsp                (ENHANCED)
│       │   ├── adminProducts.jsp
│       │   ├── adminUsers.jsp
│       │   ├── META-INF/MANIFEST.MF
│       │   ├── WEB-INF/
│       │   │   ├── web.xml
│       │   │   └── lib/
│       │   └── uploads/
│       └── resources/
│           ├── dbconfig.properties
│           ├── info.properties
│           └── razorpay.properties
└── database_schema.sql                        (NEW)
```

## Configuration

### 1. Database Configuration (`resources/dbconfig.properties`)
```properties
classname=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/shoppingcart
username=root
password=admin@123
```

### 2. Razorpay Configuration (`resources/razorpay.properties`)
```properties
razorpay.key.id=YOUR_RAZORPAY_KEY_ID
razorpay.key.secret=YOUR_RAZORPAY_KEY_SECRET
```

### 3. Update `WEB-INF/web.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="https://jakarta.ee/xml/ns/jakartaee"
    xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
    https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
    id="WebApp_ID" version="6.0">
    <display-name>ShoppingCartApp</display-name>
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```

## Key Features Implemented

### 1. Shopping Cart
- Add/update/remove items
- Cart quantity management
- Real-time price calculation
- Session-based cart persistence

### 2. Checkout Process
- Shipping information collection
- Address validation
- Multiple delivery options
- Order creation

### 3. Payment Integration
- Razorpay payment gateway
- Payment status tracking
- Order confirmation

### 4. Order Management
- Order history for customers
- Order status tracking
- Admin order processing
- Delivery tracking with tracking numbers

### 5. Product Reviews & Ratings
- 5-star rating system
- Customer reviews
- Average product rating
- Review count
- User review history

### 6. Admin Dashboard
- View all orders
- Update order status (Order Placed → Shipped → Out for Delivery → Delivered)
- Set tracking numbers
- Manage products and customers

## Database Tables

### users
- User authentication and profile storage
- Role-based access (customer/admin)

### products
- Product catalog with pricing
- Inventory management
- Product images and descriptions

### cart
- Temporary shopping cart items
- Links user to products with quantity

### orders
- Customer order records
- Shipping information
- Order status and tracking

### order_items
- Line items for each order
- Product quantity and price at time of order

### payments
- Payment transaction records
- Payment status tracking
- Razorpay integration data

### reviews
- Product reviews and ratings
- Customer feedback
- Review metadata

## API Endpoints / Servlets

### Authentication
- `LoginServlet` - User login
- `RegistrationServlet` - New user registration
- `LogoutServlet` - User logout

### Shopping
- `ProductServlet` - Product listing/details
- `CartServlet` - Cart operations (add, update, remove)
- `CheckoutServlet` - Checkout processing

### Orders
- `OrdersServlet` - Order history
- `PaymentServlet` - Payment processing
- `RazorpayCreateOrderServlet` - Create Razorpay order
- `RazorpayVerifyServlet` - Verify payment

### Reviews
- `ReviewServlet` - Add/update/delete reviews

### Admin
- `AdminServlet` - Admin operations
- `admin/orders` - Order management
- `admin/products` - Product management
- `admin/users` - User management

## User Workflows

### Customer Flow
1. Register/Login
2. Browse Products
3. Add to Cart
4. View Cart
5. Checkout (enter shipping info)
6. Payment (via Razorpay)
7. Order Confirmation
8. Track Order Status
9. Add Reviews/Ratings

### Admin Flow
1. Login with admin credentials
2. View Dashboard
3. Manage Orders (update status, add tracking)
4. View Order Details
5. Process Shipments
6. Track Deliveries

## Testing Checklist

- [ ] User Registration and Login
- [ ] Add products to cart
- [ ] Update cart quantities
- [ ] Remove cart items
- [ ] Proceed to checkout
- [ ] Complete payment
- [ ] Verify order confirmation
- [ ] View order history
- [ ] Add product reviews
- [ ] View product ratings
- [ ] Admin login
- [ ] Admin order management
- [ ] Update order status
- [ ] Set tracking numbers
- [ ] Verify status transitions

## Common Issues & Solutions

### Database Connection Error
- Verify MySQL is running
- Check credentials in `dbconfig.properties`
- Ensure database and tables exist

### Servlet Not Found
- Check web.xml for servlet mappings
- Verify servlet annotations are correct
- Ensure WEB-INF/lib has required JARs

### Session Issues
- Verify session timeout settings
- Check if cookies are enabled
- Ensure session attributes are set correctly

### Payment Issues
- Verify Razorpay credentials
- Check API key format
- Test with Razorpay test mode

## Security Considerations

1. **Password Security**
   - Hash passwords before storing
   - Use strong password validation

2. **Session Management**
   - Validate user sessions
   - Implement logout properly
   - Set appropriate session timeout

3. **SQL Injection Prevention**
   - Use parameterized queries (PreparedStatement)
   - Validate user inputs

4. **HTTPS/TLS**
   - Use HTTPS in production
   - Enable secure cookies

## Performance Optimization

1. Database indexing on:
   - user_id in orders
   - status in orders
   - productId in reviews

2. Connection pooling for database

3. Cache frequently accessed data

4. Optimize JSP rendering

## Future Enhancements

- [ ] Email notifications for orders
- [ ] SMS tracking updates
- [ ] Wishlist functionality
- [ ] Product search and filters
- [ ] Order cancellation
- [ ] Return/Refund management
- [ ] Customer support tickets
- [ ] Analytics dashboard
- [ ] Multi-currency support
- [ ] Mobile app

## Support & Contribution

For issues or contributions, please contact the development team.

## License

This project is proprietary and confidential.

---

**Last Updated:** 2024
