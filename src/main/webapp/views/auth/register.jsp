<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/views/parcials/header.jsp" />

 <section class="contact_section ">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6 px-0">
          <div class="img-box">
            <img src="images/contact-img.jpg" alt="">
          </div>
        </div>
        <div class="col-lg-5 col-md-6">
          <div class="form_container pr-0 pr-lg-5 mr-0 mr-lg-2">
            <div class="heading_container">
              <h2>
                Register
              </h2>
            </div>
            <form class="signup-form" action="${pageContext.request.contextPath}/auth/register" method="post">
              <div>
                <input type="text" placeholder="nom" name="nom"/>
              </div>
              <div>
                <input type="email" placeholder="email" name="email"/>
              </div>
              <div class="form-group">
              <label style="display: block"> </label>
              <select name="role" class="form-control">
              <option value="" disabled selected>Choose role</option>
                <option value="trainer">Trainer</option>
                <option value="member">Member</option>
              </select>

            </div>
              <div class="form-group">
              <label>Enter Password</label>
               <input
               type="password"
               class="form-control"
               placeholder="Enter Your Password"
               name="password"
                value="">

                </input>
              </div>


              <div class="d-flex ">
                <button type="submit">
                  Sign Up
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

  <jsp:include page="/views/parcials/footer.jsp" />
