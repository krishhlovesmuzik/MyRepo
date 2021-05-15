package tecketBookingDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ticketBookingMethods.BookATicket;

public class BookATicketSteps {
	BookATicket bt = new BookATicket();
	String result;

	@Given("I want to open the Web browser enter websiteURL {string}")
	public void i_want_to_open_the_web_browser_enter_website_url(String url) throws InterruptedException {
		result = bt.openBrowser_navigate(url);
		if (result == "Pass") {
			System.out.println("Successfully opened and navigated to mailtravel");
		} else {
			System.out.println("there is an error");
		}

	}

	@And("search {string}")
	public void search(String srchtxt) {
		try {
			result = bt.search(srchtxt);
			if (result == "Pass") {
				System.out.println("Successfully searched");
			} else {
				System.out.println("there is an error");
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	@When("Search results dispayed")
	public void verifyResults() throws InterruptedException {
		bt.verifyResults();
	}

	@Then("Click MoreInfo on the first result")
	public void clickMoreInfo() {

		try {
			bt.clickMore();
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@Then("Make sure it displaying days Price telephoneNumber")
	public void make_sure_it_displaying_days_price_telephone_number() {
		Assert.assertTrue(bt.isElementPresent(By.xpath("//*[@id=\"price-pin\"]")), "Day Price is not present");
		Assert.assertTrue(bt.isElementPresent(By.xpath("//*[@id=\"supplier-phone\"]")), "Day Price is not present");
	}

	@Then("Click BookOnline")
	public void click_book_online() {
		try {
			bt.bookOnline();
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@Then("Check for first Available Date is selected")
	public void check_for_first_available_date_is_selected() {
		try {
			bt.defaultRadio();
		} catch (InterruptedException e) {
			System.out.println("error");
		}

	}

	@Then("Click Continue")
	public void click_continue() {
		try {
			bt.clickContinue();
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@Then("Select standard room")
	public void select_standard_room() {
		bt.selRoom();
	}

	@Then("Click select your room and continue")
	public void click_select_your_room_and_continue() {
		try {
			bt.clickRoomContinue();
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@And("Click Continue without extra")
	public void click_continue_without_extra() {
		try {
			bt.clickRoomWithoutExtra();
		} catch (InterruptedException e) {
			System.out.println("error");
		}
	}

	@Then("Fill in Passanger Detail")
	public void fill_in_passanger_detail() throws InterruptedException  {
//		try {
//			bt.clickRoomWithoutExtra();
//		} catch (InterruptedException e) {
//			System.out.println("error");
//		}
		bt.passengerForm();
	}

	@Then("Verify Payment amount as per selected Accomodation")
	public void verify_payment_amount_as_per_selected_accomodation() {
		bt.comp();
	}

}
