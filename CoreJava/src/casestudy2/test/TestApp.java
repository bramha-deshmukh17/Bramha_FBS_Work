package casestudy2.test;

import casestudy2.controller.HouseController;
import casestudy2.controller.HouseDao;
import casestudy2.view.HouseView;

public class TestApp {

	public static void main(String[] args) {

		System.out.println("--- Welcome to the Smart Home Management System ---");
		HouseDao hd = new HouseDao();
		HouseController hc = new HouseController(hd);
		HouseView hv = new HouseView(hc);
		hv.start();

	}

}
