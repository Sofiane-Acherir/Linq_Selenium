# 🐞 Bug Report: LinqApp Automation Tests

## 📌 **Project:** LinqApp Automation
## 🛠 **Test Suite:** TestHomePageLogo

---

## **1️⃣ BUG-5678: Background color should be red but is incorrect(blue)**
### **🔍 Issue Description:**
- The test case **testBackGroundColor** fails because the background color of the input field is not red (`rgb(255, 0, 0)`) as expected.

### **📝 Steps to Reproduce:**
1. Navigate to the LinqApp homepage.
2. Enter text in the input field.
3. Blur the input field by triggering the `blur()` event via JavaScript.
4. Capture the background color of the surrounding box.
5. Compare the retrieved color with the expected red color (`rgb(255, 0, 0)`).

### **⚠️ Actual Result:**
- Background color retrieved is different from `rgb(255, 0, 0)`.

### **✅ Expected Result:**
- The background color should be `rgb(255, 0, 0)`.

### **🖼 Evidence (Screenshots & Logs):**
- Screenshot: `screenshotLogs_20250401_091728.png`
- Console Log: "This is the color in RGB format: `<actual_color>`"

### **💡 Note **
- most web application have this features however it doesn't it's a blocker or severe defect

---

## **2️⃣ BUG-1234: Invalid email is incorrectly accepted**
### **🔍 Issue Description:**
- The test case **testEmailFeature** fails because the system does not reject an invalid email format.

### **📝 Steps to Reproduce:**
1. Navigate to the LinqApp homepage.
2. Click on the "Sign in with Email" button.
3. Enter an invalid email address (`atb@gml.com`).
4. Check if an error message is displayed or if the email is accepted incorrectly.

### **⚠️ Actual Result:**
- The email is accepted without displaying a validation error.

### **✅ Expected Result:**
- The system should reject an invalid email format and display an appropriate error message.

### **🖼 Evidence (Screenshots & Logs):**
- Screenshot: `screenshotLogs_20250401_091743.png`
- Screen recorder: `testEmailFeature-2025-04-01 18.14.39.avi`
- Console Log: "BUG-1234: System should reject invalid email but does not!"

### **💡 Note :**
💡 Note:
🚨 The defect Severity is: P0 (Critical) – Must be fixed immediately.

## **📌 Additional Notes:**
- Tests are recorded using `ScreenRecorderUtil` for debugging purposes.
- Logs and screenshots are captured for further analysis.

**📝 Reported by:** Sofiane Acherir
**📅 Date:** $(04/01/2025)

