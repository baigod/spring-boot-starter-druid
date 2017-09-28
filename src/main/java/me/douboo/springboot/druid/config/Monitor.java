package me.douboo.springboot.druid.config;

public class Monitor {

	private String enabled = "enabled";
	private String DruidStatView = "/druid/*";
	private String DruidWebStatFilter = "/*";

	private String allow = "";
	private String deny = "123.123.123.123";
	private String loginUsername = "admin";
	private String loginPassword = "qwe123zxc";

	private String exclusions = "'*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*'";
	private Boolean resetEnable = false;

	public String getDruidStatView() {
		return DruidStatView;
	}

	public void setDruidStatView(String druidStatView) {
		DruidStatView = druidStatView;
	}

	public String getDruidWebStatFilter() {
		return DruidWebStatFilter;
	}

	public void setDruidWebStatFilter(String druidWebStatFilter) {
		DruidWebStatFilter = druidWebStatFilter;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public Boolean getResetEnable() {
		return resetEnable;
	}

	public void setResetEnable(Boolean resetEnable) {
		this.resetEnable = resetEnable;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}