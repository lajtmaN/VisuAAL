//
//  main.js
//
//  A project template for using arbor.js
//

(function($){

  var Renderer = function(canvas){
    var canvas = $(canvas).get(0)
    var ctx = canvas.getContext("2d");
    var particleSystem

    var that = {
      init:function(system){
        //
        // the particle system will call the init function once, right before the
        // first frame is to be drawn. it's a good place to set up the canvas and
        // to pass the canvas size to the particle system
        //
        // save a reference to the particle system for use in the .redraw() loop
        particleSystem = system

        // inform the system of the screen dimensions so it can map coords for us.
        // if the canvas is ever resized, screenSize should be called again with
        // the new dimensions
        particleSystem.screenSize(canvas.width, canvas.height) 
        particleSystem.screenPadding(80) // leave an extra 80px of whitespace per side
        
        // set up some event handlers to allow for node-dragging
        that.initMouseHandling()
      },
      
      redraw:function(){
        // 
        // redraw will be called repeatedly during the run whenever the node positions
        // change. the new positions for the nodes can be accessed by looking at the
        // .p attribute of a given node. however the p.x & p.y values are in the coordinates
        // of the particle system rather than the screen. you can either map them to
        // the screen yourself, or use the convenience iterators .eachNode (and .eachEdge)
        // which allow you to step through the actual node objects but also pass an
        // x,y point in the screen's coordinate system
        // 
        ctx.fillStyle = "white"
        ctx.fillRect(0,0, canvas.width, canvas.height)
        
        particleSystem.eachEdge(function(edge, pt1, pt2){
          // edge: {source:Node, target:Node, length:#, data:{}}
          // pt1:  {x:#, y:#}  source position in screen coords
          // pt2:  {x:#, y:#}  target position in screen coords

          // draw a line from pt1 to pt2
          ctx.strokeStyle = "rgba(0,0,0, .333)"
          ctx.lineWidth = 1
          ctx.beginPath()
          ctx.moveTo(pt1.x, pt1.y)
          ctx.lineTo(pt2.x, pt2.y)
          ctx.stroke()
        })

        particleSystem.eachNode(function(node, pt){
          // node: {mass:#, p:{x,y}, name:"", data:{}}
          // pt:   {x:#, y:#}  node position in screen coords

          // draw a rectangle centered at pt
          var w = 10
          ctx.fillStyle = (node.data.alone) ? "orange" : "black"
          ctx.fillRect(pt.x-w/2, pt.y-w/2, w,w)
        })    			
      },
      
      initMouseHandling:function(){
        // no-nonsense drag and drop (thanks springy.js)
        var dragged = null;

        // set up a handler object that will initially listen for mousedowns then
        // for moves and mouseups while dragging
        var handler = {
          clicked:function(e){
            var pos = $(canvas).offset();
            _mouseP = arbor.Point(e.pageX-pos.left, e.pageY-pos.top)
            dragged = particleSystem.nearest(_mouseP);

            if (dragged && dragged.node !== null){
              // while we're dragging, don't let physics move the node
              dragged.node.fixed = true
            }

            $(canvas).bind('mousemove', handler.dragged)
            $(window).bind('mouseup', handler.dropped)

            return false
          },
          dragged:function(e){
            var pos = $(canvas).offset();
            var s = arbor.Point(e.pageX-pos.left, e.pageY-pos.top)

            if (dragged && dragged.node !== null){
              var p = particleSystem.fromScreen(s)
              dragged.node.p = p
            }

            return false
          },

          dropped:function(e){
            if (dragged===null || dragged.node===undefined) return
            if (dragged.node !== null) dragged.node.fixed = false
            dragged.node.tempMass = 1000
            dragged = null
            $(canvas).unbind('mousemove', handler.dragged)
            $(window).unbind('mouseup', handler.dropped)
            _mouseP = null
            return false
          }
        }
        
        // start listening
        $(canvas).mousedown(handler.clicked);

      },
      
    }
    return that
  }    

  $(document).ready(function(){
    var sys = arbor.ParticleSystem(1000, 800, 0.5) // create the system with sensible repulsion/stiffness/friction
    sys.parameters({gravity:true}) // use center-gravity to make the graph settle nicely (ymmv)
    sys.renderer = Renderer("#viewport") // our newly created renderer will have its .init() method called shortly by sys...

    // add some nodes to the graph and watch it go...
    sys.addEdge('1','2')
sys.addEdge('2','3')
sys.addEdge('3','4')
sys.addEdge('4','5')
sys.addEdge('5','6')
sys.addEdge('6','7')
sys.addEdge('7','8')
sys.addEdge('8','9')
sys.addEdge('9','10')

sys.addEdge('11','12')
sys.addEdge('12','13')
sys.addEdge('13','14')
sys.addEdge('14','15')
sys.addEdge('15','16')
sys.addEdge('16','17')
sys.addEdge('17','18')
sys.addEdge('18','19')
sys.addEdge('19','20')

sys.addEdge('21','22')
sys.addEdge('22','23')
sys.addEdge('23','24')
sys.addEdge('24','25')
sys.addEdge('25','26')
sys.addEdge('26','27')
sys.addEdge('27','28')
sys.addEdge('28','29')
sys.addEdge('29','30')

sys.addEdge('31','32')
sys.addEdge('32','33')
sys.addEdge('33','34')
sys.addEdge('34','35')
sys.addEdge('35','36')
sys.addEdge('36','37')
sys.addEdge('37','38')
sys.addEdge('38','39')
sys.addEdge('39','40')

sys.addEdge('41','42')
sys.addEdge('42','43')
sys.addEdge('43','44')
sys.addEdge('44','45')
sys.addEdge('45','46')
sys.addEdge('46','47')
sys.addEdge('47','48')
sys.addEdge('48','49')
sys.addEdge('49','50')

sys.addEdge('51','52')
sys.addEdge('52','53')
sys.addEdge('53','54')
sys.addEdge('54','55')
sys.addEdge('55','56')
sys.addEdge('56','57')
sys.addEdge('57','58')
sys.addEdge('58','59')
sys.addEdge('59','60')

sys.addEdge('61','62')
sys.addEdge('62','63')
sys.addEdge('63','64')
sys.addEdge('64','65')
sys.addEdge('65','66')
sys.addEdge('66','67')
sys.addEdge('67','68')
sys.addEdge('68','69')
sys.addEdge('69','70')

sys.addEdge('71','72')
sys.addEdge('72','73')
sys.addEdge('73','74')
sys.addEdge('74','75')
sys.addEdge('75','76')
sys.addEdge('76','77')
sys.addEdge('77','78')
sys.addEdge('78','79')
sys.addEdge('79','80')

sys.addEdge('81','82')
sys.addEdge('82','83')
sys.addEdge('83','84')
sys.addEdge('84','85')
sys.addEdge('85','86')
sys.addEdge('86','87')
sys.addEdge('87','88')
sys.addEdge('88','89')
sys.addEdge('89','90')

sys.addEdge('91','92')
sys.addEdge('92','93')
sys.addEdge('93','94')
sys.addEdge('94','95')
sys.addEdge('95','96')
sys.addEdge('96','97')
sys.addEdge('97','98')
sys.addEdge('98','99')
sys.addEdge('99','100')


sys.addEdge('2','12')
sys.addEdge('3','13')
sys.addEdge('4','14')
sys.addEdge('5','15')
sys.addEdge('6','16')
sys.addEdge('7','17')
sys.addEdge('8','18')
sys.addEdge('9','19')
sys.addEdge('10','20')

sys.addEdge('12','22')
sys.addEdge('13','23')
sys.addEdge('14','24')
sys.addEdge('15','25')
sys.addEdge('16','26')
sys.addEdge('17','27')
sys.addEdge('18','28')
sys.addEdge('19','29')
sys.addEdge('20','30')

sys.addEdge('22','32')
sys.addEdge('23','33')
sys.addEdge('24','34')
sys.addEdge('25','35')
sys.addEdge('26','36')
sys.addEdge('27','37')
sys.addEdge('28','38')
sys.addEdge('29','39')
sys.addEdge('30','40')

sys.addEdge('32','42')
sys.addEdge('33','43')
sys.addEdge('34','44')
sys.addEdge('35','45')
sys.addEdge('36','46')
sys.addEdge('37','47')
sys.addEdge('38','48')
sys.addEdge('39','49')
sys.addEdge('40','50')

sys.addEdge('42','52')
sys.addEdge('43','53')
sys.addEdge('44','54')
sys.addEdge('45','55')
sys.addEdge('46','56')
sys.addEdge('47','57')
sys.addEdge('48','58')
sys.addEdge('49','59')
sys.addEdge('50','60')

sys.addEdge('52','62')
sys.addEdge('53','63')
sys.addEdge('54','64')
sys.addEdge('55','65')
sys.addEdge('56','66')
sys.addEdge('57','67')
sys.addEdge('58','68')
sys.addEdge('59','69')
sys.addEdge('60','70')

sys.addEdge('62','72')
sys.addEdge('63','73')
sys.addEdge('64','74')
sys.addEdge('65','75')
sys.addEdge('66','76')
sys.addEdge('67','77')
sys.addEdge('68','78')
sys.addEdge('69','79')
sys.addEdge('70','80')

sys.addEdge('72','82')
sys.addEdge('73','83')
sys.addEdge('74','84')
sys.addEdge('75','85')
sys.addEdge('76','86')
sys.addEdge('77','87')
sys.addEdge('78','88')
sys.addEdge('79','89')
sys.addEdge('80','90')

sys.addEdge('82','92')
sys.addEdge('83','93')
sys.addEdge('84','94')
sys.addEdge('85','95')
sys.addEdge('86','96')
sys.addEdge('87','97')
sys.addEdge('88','98')
sys.addEdge('89','99')
sys.addEdge('90','100')











sys.addEdge('2','1')
sys.addEdge('3','2')
sys.addEdge('4','3')
sys.addEdge('5','4')
sys.addEdge('6','5')
sys.addEdge('7','6')
sys.addEdge('8','7')

sys.addEdge('10','9')

sys.addEdge('12','11')
sys.addEdge('13','12')
sys.addEdge('14','13')
sys.addEdge('15','14')
sys.addEdge('16','15')
sys.addEdge('17','16')
sys.addEdge('18','17')

sys.addEdge('20','19')

sys.addEdge('22','21')
sys.addEdge('23','22')
sys.addEdge('24','23')
sys.addEdge('25','24')
sys.addEdge('26','25')
sys.addEdge('27','26')
sys.addEdge('28','27')

sys.addEdge('30','29')

sys.addEdge('32','31')
sys.addEdge('33','32')
sys.addEdge('34','33')
sys.addEdge('35','34')
sys.addEdge('36','35')
sys.addEdge('37','36')
sys.addEdge('38','37')

sys.addEdge('40','39')

sys.addEdge('42','41')
sys.addEdge('43','42')
sys.addEdge('44','43')
sys.addEdge('45','44')
sys.addEdge('46','45')
sys.addEdge('47','46')
sys.addEdge('48','47')

sys.addEdge('50','49')

sys.addEdge('52','51')
sys.addEdge('53','52')
sys.addEdge('54','53')
sys.addEdge('55','54')
sys.addEdge('56','55')
sys.addEdge('57','56')
sys.addEdge('58','57')

sys.addEdge('60','59')

sys.addEdge('62','61')
sys.addEdge('63','62')
sys.addEdge('64','63')
sys.addEdge('65','64')
sys.addEdge('66','65')
sys.addEdge('67','66')
sys.addEdge('68','67')

sys.addEdge('70','69')

sys.addEdge('72','71')
sys.addEdge('73','72')
sys.addEdge('74','73')
sys.addEdge('75','74')
sys.addEdge('76','75')
sys.addEdge('77','76')
sys.addEdge('78','77')

sys.addEdge('80','79')

sys.addEdge('82','81')
sys.addEdge('83','82')
sys.addEdge('84','83')
sys.addEdge('85','84')
sys.addEdge('86','85')
sys.addEdge('87','86')
sys.addEdge('88','87')

sys.addEdge('90','89')

sys.addEdge('92','91')
sys.addEdge('93','92')
sys.addEdge('94','93')
sys.addEdge('95','94')
sys.addEdge('96','95')
sys.addEdge('97','96')
sys.addEdge('98','97')

sys.addEdge('100','99')










sys.addEdge('11','1')
sys.addEdge('12','2')
sys.addEdge('13','3')
sys.addEdge('14','4')
sys.addEdge('15','5')
sys.addEdge('16','6')
sys.addEdge('17','7')
sys.addEdge('18','8')
sys.addEdge('19','9')
sys.addEdge('20','10')
sys.addEdge('21','11')
sys.addEdge('22','12')
sys.addEdge('23','13')
sys.addEdge('24','14')
sys.addEdge('25','15')
sys.addEdge('26','16')
sys.addEdge('27','17')
sys.addEdge('28','18')
sys.addEdge('29','19')
sys.addEdge('30','20')
sys.addEdge('31','21')
sys.addEdge('32','22')
sys.addEdge('33','23')
sys.addEdge('34','24')
sys.addEdge('35','25')
sys.addEdge('36','26')
sys.addEdge('37','27')
sys.addEdge('38','28')
sys.addEdge('39','29')
sys.addEdge('40','30')
sys.addEdge('41','31')
sys.addEdge('42','32')
sys.addEdge('43','33')
sys.addEdge('44','34')
sys.addEdge('45','35')
sys.addEdge('46','36')
sys.addEdge('47','37')
sys.addEdge('48','38')
sys.addEdge('49','39')
sys.addEdge('50','40')
sys.addEdge('51','41')
sys.addEdge('52','42')
sys.addEdge('53','43')
sys.addEdge('54','44')
sys.addEdge('55','45')
sys.addEdge('56','46')
sys.addEdge('57','47')
sys.addEdge('58','48')
sys.addEdge('59','49')
sys.addEdge('60','50')
sys.addEdge('61','51')
sys.addEdge('62','52')
sys.addEdge('63','53')
sys.addEdge('64','54')
sys.addEdge('65','55')
sys.addEdge('66','56')
sys.addEdge('67','57')
sys.addEdge('68','58')
sys.addEdge('69','59')
sys.addEdge('70','60')
sys.addEdge('71','61')
sys.addEdge('72','62')
sys.addEdge('73','63')
sys.addEdge('74','64')
sys.addEdge('75','65')
sys.addEdge('76','66')
sys.addEdge('77','67')
sys.addEdge('78','68')
sys.addEdge('79','69')
sys.addEdge('80','70')
sys.addEdge('81','71')
sys.addEdge('82','72')
sys.addEdge('83','73')
sys.addEdge('84','74')
sys.addEdge('85','75')
sys.addEdge('86','76')
sys.addEdge('87','77')
sys.addEdge('88','78')
sys.addEdge('89','79')
sys.addEdge('90','80')
sys.addEdge('91','81')
sys.addEdge('92','82')
sys.addEdge('93','83')
sys.addEdge('94','84')
sys.addEdge('95','85')
sys.addEdge('96','86')
sys.addEdge('97','87')
sys.addEdge('98','88')
sys.addEdge('99','89')
sys.addEdge('100','90')

    // or, equivalently:
    //
    // sys.graft({
    //   nodes:{
    //     f:{alone:true, mass:.25}
    //   }, 
    //   edges:{
    //     a:{ b:{},
    //         c:{},
    //         d:{},
    //         e:{}
    //     }
    //   }
    // })
    
  })

})(this.jQuery)