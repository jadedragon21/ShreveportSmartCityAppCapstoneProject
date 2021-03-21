  var map;


//  let coords = {lat: 39.9612, lng: -82.9988}


  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      center: coords,
      zoom: 10,
      scrollwheel: false
    });

    let image = {
            url: 'images/molang king.png',
            scaledSize: new google.maps.Size(70, 70)
      };

    let marker = new google.maps.Marker({
            position: coords,
            map: map,
            icon: image,
            animation: google.maps.Animation.BOUNCE

          });

    console.log(state)

    const transitLayer = new google.maps.TransitLayer();
      transitLayer.setMap(map);
    const trafficLayer = new google.maps.TrafficLayer();
      trafficLayer.setMap(map);

     let contentString = "<h2>" + city + ", " + state + ", Where you can bring your hard work to fruition!</h2>";

      let infowindow = new google.maps.InfoWindow({
            content: contentString
        })
    google.maps.event.addListener(marker, 'click', () => infowindow.open(map, marker));

}

//ham navbar/accordian
$(document).ready(function () {

  $('.first-button').on('click', function () {

    $('.animated-icon1').toggleClass('open');
  });
  $('.second-button').on('click', function () {

    $('.animated-icon2').toggleClass('open');
  });
  $('.third-button').on('click', function () {

    $('.animated-icon3').toggleClass('open');
  });
});
//ham navbar


  /* multi carousel*/
$('#recipeCarousel').carousel({
  interval: 100
})

$('.carousel .carousel-item').each(function(){
    var minPerSlide = 3;
    var next = $(this).next();
    if (!next.length) {
    next = $(this).siblings(':first');
    }
    next.children(':first-child').clone().appendTo($(this));

    for (var i=0;i<minPerSlide;i++) {
        next=next.next();
        if (!next.length) {
        	next = $(this).siblings(':first');
      	}

        next.children(':first-child').clone().appendTo($(this));
      }
});



