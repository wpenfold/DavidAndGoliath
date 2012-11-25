package Test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Main.Location;
import Main.MainWindow;


public class TestBasicClass {
public MainWindow mainWindow;
	
	@Before
public void beforeMethod(){
	mainWindow = new MainWindow();
}


//test the function getHandShootingLocation works
@Test
public void testGetHandShootingLocation(){
	Location place1 = mainWindow.playingArea.david.getHandShootingLocation(0);
	Assert.assertEquals(place1.x, 220);
	Assert.assertEquals(place1.y, 220);
	
	Location place2 = mainWindow.playingArea.david.getHandShootingLocation(20);
	Assert.assertEquals(place2.x, 200);
	Assert.assertEquals(place2.y, 200);
}

//test class Rock
//test the function updateRockLocation works
@Test
public void testUpdateRockLocation(){
	mainWindow.playingArea.rock.location.setX(50);
	mainWindow.playingArea.rock.location.setY(50);
	mainWindow.playingArea.rock.speed = 20;
	mainWindow.playingArea.rock.angle = 30;
	mainWindow.playingArea.rock.updateRockLocation(mainWindow.playingArea.theGraphics);
	Assert.assertEquals(mainWindow.playingArea.rock.location.getX(), 60);
	Assert.assertEquals(mainWindow.playingArea.rock.location.getY(), 40);
}

//test class Sling 1of2
//test the function updateAngle works
@Test
public void testUpdateAngle(){
	mainWindow.playingArea.sling.endOfSling.setX(225);
	mainWindow.playingArea.sling.endOfSling.setY(225);
	mainWindow.playingArea.sling.updateAngle(0);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.x,225);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.y,225);
}

//test class Sling 2of2
//test the funciton drawNextEndOfSlingLocation works
public void testDrawNextEndOfSlingLocation(){
	//check moving to the left down the sling without an angle
	mainWindow.playingArea.sling.endOfSling.setX(20);
	mainWindow.playingArea.sling.endOfSling.setY(50);
	mainWindow.playingArea.sling.drawNextEndOfSlingLocation(45,5,mainWindow.playingArea.theGraphics);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.getX(), 18);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.getY(), 48);
	
	//check moving to the left down the sling with an angle
	mainWindow.playingArea.sling.endOfSling.setX(20);
	mainWindow.playingArea.sling.endOfSling.setY(50);
	mainWindow.playingArea.sling.drawNextEndOfSlingLocation(0,5,mainWindow.playingArea.theGraphics);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.getX(), 15);
	Assert.assertEquals(mainWindow.playingArea.sling.endOfSling.getY(), 50);
}

//test class PlayingArea
public void testSetAngle(){
	//test 45 degree angle
	mainWindow.playingArea.lineStart.setX(0);
	mainWindow.playingArea.lineStart.setY(0);
	mainWindow.playingArea.lineEnd.setX(15);
	mainWindow.playingArea.lineEnd.setX(15);
	mainWindow.playingArea.setAngle();
	Assert.assertEquals(mainWindow.playingArea.angle, 45);
	
	//test 0 degree angle
	mainWindow.playingArea.lineStart.setX(15);
	mainWindow.playingArea.lineStart.setY(0);
	mainWindow.playingArea.lineEnd.setX(0);
	mainWindow.playingArea.lineEnd.setY(0);
	mainWindow.playingArea.setAngle();
	Assert.assertEquals(mainWindow.playingArea.angle, 0);
	
	//test 30 degree angle   3-4-5 triangle
	mainWindow.playingArea.lineStart.setX(15);
	mainWindow.playingArea.lineStart.setY(0);
	mainWindow.playingArea.lineEnd.setX(0);
	mainWindow.playingArea.lineEnd.setY(20);
	mainWindow.playingArea.setAngle();
	Assert.assertEquals(mainWindow.playingArea.angle, 30);
}


}