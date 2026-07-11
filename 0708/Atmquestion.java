/*input:
 - card (金融卡)
 - password (密碼)
 - withdrawal_amount (提款金額)

process:
 - check_password = 檢查密碼是否正確
 - check_balance = 檢查帳戶餘額是否大於等於 withdrawal_amount
 - check_atm_cash = 檢查 ATM 機台內現鈔是否足夠
 - account_balance = account_balance - withdrawal_amount (扣款)
 - atm_cash_reserve = atm_cash_reserve - withdrawal_amount (扣減機台現金)

output:
 - cash (實體現鈔)
 - return_card (退卡)
 - receipt (交易明細/餘額顯示)*/