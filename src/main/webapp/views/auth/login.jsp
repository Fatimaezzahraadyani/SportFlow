<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/views/parcials/header.jsp" />

<section class="login_section">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="form_container">
                    <h2>Login</h2>
                    <form action="${pageContext.request.contextPath}/auth/login" method="post">
                        <div>
                            <input type="email" name="email" placeholder="Email" required />
                        </div>
                        <div>
                            <input type="password" name="password" placeholder="Password" required />
                        </div>
                        <div class="d-flex">
                            <button type="submit">Login</button>
                        </div>
                    </form>
                    <c:if test="${not empty loginError}">
                        <div class="error_message">
                            <p>${loginError}</p>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/views/parcials/footer.jsp" />
