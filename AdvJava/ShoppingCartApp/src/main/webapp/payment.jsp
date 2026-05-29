<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Payment</title>
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body class="bg-gray-100 min-h-screen">
            <nav class="bg-blue-600 text-white px-6 py-4 flex justify-between items-center shadow-md">
                <h1 class="text-xl font-bold">Payment</h1>
                <div class="flex items-center gap-3">
                    <a href="${pageContext.request.contextPath}/products"
                        class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Shop</a>
                    <a href="${pageContext.request.contextPath}/cart"
                        class="bg-white text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-gray-100 transition">Cart</a>
                </div>
            </nav>

            <div class="max-w-2xl mx-auto mt-10 px-4">
                <div class="bg-white rounded-2xl shadow-lg overflow-hidden">
                    <div class="bg-gradient-to-r from-blue-600 to-blue-800 text-white px-6 py-4">
                        <h2 class="text-2xl font-bold">Complete Your Payment</h2>
                        <p class="text-blue-100 mt-1">Order #${orderId}</p>
                    </div>

                    <div class="p-8">
                        <!-- Payment Status -->
                        <c:if test="${not empty payment}">
                            <c:choose>
                                <c:when test="${payment.status == 'Paid'}">
                                    <div
                                        class="mb-6 p-4 bg-green-100 border border-green-300 rounded-lg text-green-700">
                                        ✓ Payment Already Completed
                                    </div>
                                </c:when>
                                <c:when test="${payment.status == 'Pending'}">
                                    <div
                                        class="mb-6 p-4 bg-yellow-100 border border-yellow-300 rounded-lg text-yellow-700">
                                        ⏳ Pending Payment - Please complete your payment below
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:if>

                        <!-- Payment Form -->
                        <form method="POST" action="paymentProcess" onsubmit="return validateForm()">
                            <!-- Order Details -->
                            <div class="bg-gray-50 p-4 rounded-lg mb-6">
                                <h3 class="text-lg font-semibold text-gray-700 mb-4">Order Details</h3>
                                <div class="space-y-3">
                                    <div class="flex justify-between">
                                        <span class="text-gray-600">Order ID:</span>
                                        <span class="font-semibold text-gray-800">${orderId}</span>
                                    </div>
                                    <div class="flex justify-between">
                                        <span class="text-gray-600">Amount:</span>
                                        <span class="font-semibold text-gray-800">₹ ${amount}</span>
                                    </div>
                                </div>
                                <input type="hidden" name="orderId" value="${orderId}">
                                <input type="hidden" name="amount" value="${amount}">
                            </div>

                            <!-- Delivery Address -->
                            <div class="mb-6">
                                <h3 class="text-lg font-semibold text-gray-700 mb-4">Delivery Address</h3>
                                <div class="space-y-4">
                                    <div>
                                        <label class="block text-sm font-medium text-gray-600 mb-2">Street Address
                                            *</label>
                                        <input type="text" name="streetAddress"
                                            value="${not empty deliveryAddress ? deliveryAddress.streetAddress : ''}"
                                            placeholder="Enter your street address"
                                            class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                    </div>

                                    <div class="grid grid-cols-2 gap-4">
                                        <div>
                                            <label class="block text-sm font-medium text-gray-600 mb-2">City *</label>
                                            <input type="text" name="city"
                                                value="${not empty deliveryAddress ? deliveryAddress.city : ''}"
                                                placeholder="City"
                                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                        </div>
                                        <div>
                                            <label class="block text-sm font-medium text-gray-600 mb-2">State *</label>
                                            <input type="text" name="state"
                                                value="${not empty deliveryAddress ? deliveryAddress.state : ''}"
                                                placeholder="State"
                                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                        </div>
                                    </div>

                                    <div class="grid grid-cols-2 gap-4">
                                        <div>
                                            <label class="block text-sm font-medium text-gray-600 mb-2">ZIP Code
                                                *</label>
                                            <input type="text" name="zipCode"
                                                value="${not empty deliveryAddress ? deliveryAddress.zipCode : ''}"
                                                placeholder="ZIP Code"
                                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                        </div>
                                        <div>
                                            <label class="block text-sm font-medium text-gray-600 mb-2">Phone *</label>
                                            <input type="tel" name="phone"
                                                value="${not empty deliveryAddress ? deliveryAddress.phone : ''}"
                                                placeholder="10-digit phone number"
                                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Payment Method -->
                            <div class="mb-6">
                                <h3 class="text-lg font-semibold text-gray-700 mb-4">Payment Method</h3>
                                <div class="space-y-3">
                                    <label
                                        class="flex items-center p-3 border-2 border-blue-500 rounded-lg cursor-pointer bg-blue-50">
                                        <input type="radio" name="paymentMethod" value="Card" checked class="w-4 h-4">
                                        <span class="ml-3 text-gray-700 font-medium">Credit/Debit Card</span>
                                    </label>
                                    <label
                                        class="flex items-center p-3 border-2 border-gray-300 rounded-lg cursor-pointer hover:border-blue-500 hover:bg-gray-50">
                                        <input type="radio" name="paymentMethod" value="NetBanking" class="w-4 h-4">
                                        <span class="ml-3 text-gray-700 font-medium">Net Banking</span>
                                    </label>
                                    <label
                                        class="flex items-center p-3 border-2 border-gray-300 rounded-lg cursor-pointer hover:border-blue-500 hover:bg-gray-50">
                                        <input type="radio" name="paymentMethod" value="Wallet" class="w-4 h-4">
                                        <span class="ml-3 text-gray-700 font-medium">Digital Wallet</span>
                                    </label>
                                </div>
                            </div>

                            <!-- Payment Summary -->
                            <div class="bg-blue-50 border border-blue-200 rounded-lg p-4 mb-6">
                                <div class="flex justify-between items-center mb-2">
                                    <span class="text-gray-600">Order Amount:</span>
                                    <span class="font-semibold">₹ ${amount}</span>
                                </div>
                                <div class="flex justify-between items-center mb-2">
                                    <span class="text-gray-600">Delivery Charge:</span>
                                    <span class="font-semibold">₹ 0.00</span>
                                </div>
                                <div class="border-t border-blue-200 pt-2 mt-2 flex justify-between items-center">
                                    <span class="text-lg font-bold text-gray-800">Total Amount:</span>
                                    <span class="text-2xl font-bold text-blue-600">₹ ${amount}</span>
                                </div>
                            </div>

                            <!-- Submit Button -->
                            <button type="submit"
                                class="w-full bg-green-600 hover:bg-green-700 text-white font-bold py-3 rounded-lg transition duration-200 flex items-center justify-center gap-2">
                                <span>🔒</span>
                                <span>Complete Payment</span>
                            </button>

                            <p class="text-center text-gray-500 text-sm mt-4">
                                Your payment is secured and encrypted
                            </p>
                        </form>

                        <!-- Back to Cart -->
                        <div class="mt-6 text-center">
                            <a href="${pageContext.request.contextPath}/cart"
                                class="text-blue-600 hover:text-blue-800 font-medium">
                                ← Continue Shopping
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                function validateForm() {
                    const streetAddress = document.querySelector('input[name="streetAddress"]').value.trim();
                    const city = document.querySelector('input[name="city"]').value.trim();
                    const state = document.querySelector('input[name="state"]').value.trim();
                    const zipCode = document.querySelector('input[name="zipCode"]').value.trim();
                    const phone = document.querySelector('input[name="phone"]').value.trim();

                    if (!streetAddress || !city || !state || !zipCode || !phone) {
                        alert('Please fill in all delivery address fields');
                        return false;
                    }

                    if (phone.length !== 10 || !/^\d+$/.test(phone)) {
                        alert('Please enter a valid 10-digit phone number');
                        return false;
                    }

                    if (!/^\d{5,6}$/.test(zipCode)) {
                        alert('Please enter a valid ZIP code');
                        return false;
                    }

                    return true;
                }
            </script>
        </body>

        </html>