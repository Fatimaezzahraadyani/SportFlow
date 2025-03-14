<jsp:include page="/views/parcials/header.jsp" />
<%@ page import="SportFlow.model.User" %>


  <section class="slider_section position-relative">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-lg-8 col-md-10">
                <div class="detail-box text-center">
                  <h3 class="display-4 mb-4">Dashboard Trainer</h3>
                  <p class="lead mb-5">Welcome back </p>
                  <button type="submit" class="btn btn-primary">Consulter Ma liste</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


  </section>

  <style>
    .slider_section {
      background: linear-gradient(45deg, #f7f7f7, #e0e0e0);
      padding: 50px 0;
      position: relative;
    }

    .carousel-item {
      background-image: url('your-image-url.jpg');
      background-size: cover;
      background-position: center;
      height: 400px;
    }

    .detail-box h3 {
      font-size: 2.5rem;
      font-weight: bold;
      color: #333;
    }

    .detail-box p {
      font-size: 1.25rem;
      color: #555;
    }

    .btn-primary {
      background-color: #007bff;
      border: none;
      padding: 15px 30px;
      font-size: 1.25rem;
      border-radius: 30px;
      transition: background-color 0.3s;
    }

    .btn-primary:hover {
      background-color: #0056b3;
    }

    .lines {
      display: flex;
      justify-content: space-between;
      padding-top: 20px;
    }

    .line {
      width: 30%;
      height: 3px;
      background-color: #007bff;
      border-radius: 5px;
    }
  </style>



<jsp:include page="/views/parcials/footer.jsp" />