package com.bjdvt.platform.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjdvt.platform.mapper.AppMapper;
import com.bjdvt.platform.mapper.AppUserMapper;
import com.bjdvt.platform.mapper.ComponentMapper;
import com.bjdvt.platform.mapper.DataMapper;
import com.bjdvt.platform.mapper.PageGroupMapper;
import com.bjdvt.platform.mapper.PageMapper;
import com.bjdvt.platform.mapper.PropsMapper;
import com.bjdvt.platform.mapper.StyleBorderBottomMapper;
import com.bjdvt.platform.mapper.StyleBorderMapper;
import com.bjdvt.platform.mapper.StyleBoxMapper;
import com.bjdvt.platform.mapper.StyleButtonMapper;
import com.bjdvt.platform.mapper.StyleLineMarkMapper;
import com.bjdvt.platform.mapper.StylePaddingMapper;
import com.bjdvt.platform.mapper.StylePhotoMapper;
import com.bjdvt.platform.mapper.StyleTextMapper;
import com.bjdvt.platform.mapper.TabbarMapper;
import com.bjdvt.platform.mapper.TabbaritemMapper;
import com.bjdvt.platform.mapper.TextMapper;
import com.bjdvt.platform.model.App;
import com.bjdvt.platform.model.AppExample;
import com.bjdvt.platform.model.Component;
import com.bjdvt.platform.model.ComponentExample;
import com.bjdvt.platform.model.Data;
import com.bjdvt.platform.model.DataExample;
import com.bjdvt.platform.model.Page;
import com.bjdvt.platform.model.PageExample;
import com.bjdvt.platform.model.PageGroup;
import com.bjdvt.platform.model.Props;
import com.bjdvt.platform.model.PropsExample;
import com.bjdvt.platform.model.StyleBorder;
import com.bjdvt.platform.model.StyleBorderBottom;
import com.bjdvt.platform.model.StyleBorderBottomExample;
import com.bjdvt.platform.model.StyleBorderExample;
import com.bjdvt.platform.model.StyleBox;
import com.bjdvt.platform.model.StyleBoxExample;
import com.bjdvt.platform.model.StyleButton;
import com.bjdvt.platform.model.StyleButtonExample;
import com.bjdvt.platform.model.StyleLineMark;
import com.bjdvt.platform.model.StyleLineMarkExample;
import com.bjdvt.platform.model.StylePadding;
import com.bjdvt.platform.model.StylePaddingExample;
import com.bjdvt.platform.model.StylePhoto;
import com.bjdvt.platform.model.StylePhotoExample;
import com.bjdvt.platform.model.StyleText;
import com.bjdvt.platform.model.StyleTextExample;
import com.bjdvt.platform.model.Tabbar;
import com.bjdvt.platform.model.TabbarExample;
import com.bjdvt.platform.model.Tabbaritem;
import com.bjdvt.platform.model.TabbaritemExample;
import com.bjdvt.platform.utils.MyFileUtils;
import com.platform.dao.ApiTokenMapper;
import com.platform.entity.SysUserEntity;
import com.platform.utils.Constant;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class AppServiceImp {
	@Autowired
	private AppMapper appMapper;
	@Autowired
	private AppUserMapper appUserMapper;
	@Autowired
	private ComponentMapper componentMapper;
	@Autowired
	private DataMapper dataMapper;
	@Autowired
	private PageGroupMapper pageGroupMapper;
	@Autowired
	private PageMapper pageMapper;
	@Autowired
	private PropsMapper propsMapper;
	@Autowired
	private StyleBorderBottomMapper styleBorderBottomMapper;
	@Autowired
	private StyleBorderMapper styleBorderMapper;
	@Autowired
	private StyleBoxMapper styleBoxMapper;
	@Autowired
	private StyleButtonMapper styleButtonMapper;
	@Autowired
	private StyleLineMarkMapper styleLineMarkMapper;
	@Autowired
	private StylePaddingMapper stylePaddingMapper;
	@Autowired
	private StylePhotoMapper stylePhotoMapper;
	@Autowired
	private StyleTextMapper styleTextMapper;
	@Autowired
	private TextMapper textMapper;
	
	@Autowired
	private TabbarMapper tabbarMapper;
	
	@Autowired
	private TabbaritemMapper tabbaritemMapper;
	
	 @Autowired
	 private ApiTokenMapper tokenDao;
	 
	
	public App getApp(String id) {
		App app=appMapper.selectByPrimaryKey(id);
		if(app==null) {
			return null;
		}
		PageExample pageExample=new PageExample();
		pageExample.createCriteria().andPageGroupIdEqualTo(app.getId());
		List<Page>pageList=pageMapper.selectByExample(pageExample);
		List<Page> pages=new ArrayList();
		for(Page page:pageList) {
			Page tmpPage=getPage(page.getId());
			pages.add(tmpPage);
		}
		app.setPages(pages);
		Tabbar tabbar=getTabbar(app.getId());
		app.setTabbar(tabbar);
		return app;
		
	}
	
	public Tabbar getTabbar(String appId){
		TabbarExample tabbarExample=new TabbarExample();
		tabbarExample.createCriteria().andAppIdEqualTo(appId);
		List<Tabbar> tabbarList=tabbarMapper.selectByExample(tabbarExample);
		if(tabbarList.size()>0) {
			Tabbar tabbar=tabbarList.get(0);
			TabbaritemExample tabbaritemExample=new TabbaritemExample();
			tabbaritemExample.createCriteria().andTabbarIdEqualTo(tabbar.getId());
			List<Tabbaritem> tabbaritemList=tabbaritemMapper.selectByExample(tabbaritemExample);
			tabbar.setList(tabbaritemList);
			return tabbar;
		}
		return null;
		
	}
	public Page getPage(String id) {
		Page page=pageMapper.selectByPrimaryKey(id);
		ComponentExample componentExample=new ComponentExample();
		componentExample.createCriteria().andPageIdEqualTo(id);
		List<Component> componentList=componentMapper.selectByExample(componentExample);
		page.setComponents(componentList);
		for(Component component:componentList) {
			component.setUid(MyFileUtils.getUUID());
			PropsExample propsExample=new PropsExample();
			propsExample.createCriteria().andComponentIdEqualTo(component.getId());
			List<Props> propsList=propsMapper.selectByExample(propsExample);
			if(propsList.size()>0) {
				Props props=propsList.get(0);
				component.setProps(props);
				props.setStyleBorder(getStyleBorder(props.getId()));
				props.setStyleBorderBottom(getStyleBorderBottom(props.getId()));
				props.setStyleBox(getStyleBox(props.getId()));
				props.setStyleButton(getStyleButton(props.getId()));
				props.setStyleLineMark(getStyleLineMark(props.getId()));
				props.setStylePadding(getStylePadding(props.getId()));
				props.setStyleText(getStyleText(props.getId()));
				props.setStylePhoto(getStylePhoto(props.getId()));
				props.setDataList(getDataList(props.getId()));
				
			}
		}
		
		return page;
	}
	private StyleBorder getStyleBorder(Integer propsId) {
		StyleBorderExample styleBorderExample=new StyleBorderExample();
		styleBorderExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleBorder> styleBorderList=styleBorderMapper.selectByExample(styleBorderExample);
		if(styleBorderList.size()>0) {
			return styleBorderList.get(0);
		}
		return null;
	}
	private StyleBorderBottom getStyleBorderBottom(Integer propsId) {
		StyleBorderBottomExample styleBorderBottomExample=new StyleBorderBottomExample();
		styleBorderBottomExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleBorderBottom> styleBorderBottomList=styleBorderBottomMapper.selectByExample(styleBorderBottomExample);
		if(styleBorderBottomList.size()>0) {
			return styleBorderBottomList.get(0);
		}
		return null;
	}
	
	private StyleBox getStyleBox(Integer propsId) {
		StyleBoxExample styleBoxExample=new StyleBoxExample();
		styleBoxExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleBox> styleBoxList=styleBoxMapper.selectByExample(styleBoxExample);
		if(styleBoxList.size()>0) {
			return styleBoxList.get(0);
		}
		return null;
	}
	
	private StyleButton getStyleButton(Integer propsId) {
		StyleButtonExample styleButtonExample=new StyleButtonExample();
		styleButtonExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleButton> styleButtonList=styleButtonMapper.selectByExample(styleButtonExample);
		if(styleButtonList.size()>0) {
			return styleButtonList.get(0);
		}
		return null;
	}
	
	private StyleLineMark getStyleLineMark(Integer propsId) {
		StyleLineMarkExample styleLineMarkExample=new StyleLineMarkExample();
		styleLineMarkExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleLineMark> styleLineMarkList=styleLineMarkMapper.selectByExample(styleLineMarkExample);
		if(styleLineMarkList.size()>0) {
			return styleLineMarkList.get(0);
		}
		return null;
	}
	

	private StylePadding getStylePadding(Integer propsId) {
		StylePaddingExample stylePaddingExample=new StylePaddingExample();
		stylePaddingExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StylePadding> stylePaddingList=stylePaddingMapper.selectByExample(stylePaddingExample);
		if(stylePaddingList.size()>0) {
			return stylePaddingList.get(0);
		}
		return null;
	}
	private StyleText getStyleText(Integer propsId) {
		StyleTextExample styleTextExample=new StyleTextExample();
		styleTextExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StyleText> styleTextList=styleTextMapper.selectByExample(styleTextExample);
		if(styleTextList.size()>0) {
			return styleTextList.get(0);
		}
		return null;
	}
	private StylePhoto getStylePhoto(Integer propsId) {
		StylePhotoExample stylePhotoExample=new StylePhotoExample();
		stylePhotoExample.createCriteria().andPropsIdEqualTo(propsId);
		List<StylePhoto> stylePhotoList=stylePhotoMapper.selectByExample(stylePhotoExample);
		if(stylePhotoList.size()>0) {
			return stylePhotoList.get(0);
		}
		return null;
	}
	private List<Data> getDataList(Integer propsId) {
		DataExample dataExample=new DataExample();
		dataExample.createCriteria().andPropsIdEqualTo(propsId);
		List<Data> dataBoxList=dataMapper.selectByExample(dataExample);
		
		return dataBoxList;
	}
	/**
	 * 保存App
	 * @param app
	 * @return
	 */
	public App save(App app) {
		System.out.println("begin save app");
		if(app.getId()!=null) {	
			App tmpApp=getApp(app.getId());
			if(tmpApp!=null) {
				delete(tmpApp);
			}
		}
		 appMapper.insert(app);
		    
		    for(Page page:app.getPages()) {
				page.setPageGroupId(app.getId());
				savePage(page);
			}
			saveTabbar(app.getTabbar());
		return app;
		
	}
	private void delete(App app) {
		
		for(Page page:app.getPages()) {
			delete(page);
		}
		
		if(app.getTabbar()!=null) {
			delete(app.getTabbar());
		}
		appMapper.deleteByPrimaryKey(app.getId());
	}
	private void delete(Page page) {
		pageMapper.deleteByPrimaryKey(page.getId());
		for(Component component:page.getComponents()) {
			delete(component);
		}
	}
	private void delete(Component component) {
		if(component!=null) {
			componentMapper.deleteByPrimaryKey(component.getId());
			delete(component.getProps());
		}
	}
	private void delete(Props props) {
		if(props!=null) {
			propsMapper.deleteByPrimaryKey(props.getId());
			StyleBorderExample styleBorderExample=new StyleBorderExample();
			styleBorderExample.createCriteria().andPropsIdEqualTo(props.getId());
			styleBorderMapper.deleteByExample(styleBorderExample);
			
			StyleBorderBottomExample styleBorderBottomExample=new StyleBorderBottomExample();
			styleBorderBottomExample.createCriteria().andPropsIdEqualTo(props.getId());
			styleBorderBottomMapper.deleteByExample(styleBorderBottomExample);
			
			StyleBoxExample styleBoxExample=new StyleBoxExample();
			styleBoxExample.createCriteria().andPropsIdEqualTo(props.getId());
			styleBoxMapper.deleteByExample(styleBoxExample);
			
			
		}
	}
	
	private void delete(Tabbar tabbar) {
		if(tabbar!=null) {
			tabbarMapper.deleteByPrimaryKey(tabbar.getId());
			for(Tabbaritem tabbarItem:tabbar.getList()) {
				tabbaritemMapper.deleteByPrimaryKey(tabbarItem.getId());
			}
		}
	}
	private void saveTabbar(Tabbar tabbar) {
		if(tabbar!=null) {
			tabbarMapper.insert(tabbar);
			for(Tabbaritem tabbarItem:tabbar.getList()) {
				tabbarItem.setTabbarId(tabbar.getId());
				tabbaritemMapper.insert(tabbarItem);
			}
		}
	}
	public void savePageGroup(PageGroup pageGroup) {
		pageGroupMapper.insert(pageGroup);
		for(Page page :pageGroup.getPages()) {
			page.setPageGroupId(pageGroup.getId());
			savePage(page);
			
		}
	}
	public void savePage(Page page) {
		String uid=MyFileUtils.getUUID();
		page.setId(uid);
		pageMapper.insert(page);
		for(Component component:page.getComponents()) {
			component.setPageId(page.getId());
			component.setId(null);
			saveComponent(component);
		}
		
	}
	public void saveComponent(Component component) {
		componentMapper.insert(component);
		if(component.getProps()!=null) {
			component.getProps().setId(null);
			component.getProps().setComponentId(component.getId());
			saveProps(component.getProps());
		}
		
	}
	public void saveProps(Props props) {
		propsMapper.insert(props);
		StyleBorder styleBorder=props.getStyleBorder();
		if(styleBorder!=null) {
			styleBorder.setId(null);
			styleBorder.setPropsId(props.getId());
			saveStyleBorder(styleBorder);
		}
		StyleBorderBottom styleBorderBottom=props.getStyleBorderBottom();
		if(styleBorderBottom!=null) {
			styleBorderBottom.setId(null);
			styleBorderBottom.setPropsId(props.getId());
			saveStyleBorderBottom(styleBorderBottom);
		}
		StyleBox styleBox=props.getStyleBox();
		if(styleBox!=null) {
			styleBox.setId(null);
			styleBox.setPropsId(props.getId());
			saveStyleBox(styleBox);
		}
		StyleButton styleButton=props.getStyleButton();
		if(styleButton!=null) {
			styleButton.setId(null);
			styleButton.setPropsId(props.getId());
			saveStyleButtonx(styleButton);
		}
		
		StyleLineMark styleLineMark=props.getStyleLineMark();
		if(styleLineMark!=null) {
			styleLineMark.setId(null);
			styleLineMark.setPropsId(props.getId());
			saveStyleLineMark(styleLineMark);
		}
		StylePadding stylePadding=props.getStylePadding();
		if(stylePadding!=null) {
			stylePadding.setId(null);
			stylePadding.setPropsId(props.getId());
			saveStylePadding(stylePadding);
		}
		StyleText styleText=props.getStyleText();
		if(styleText!=null) {
			styleText.setId(null);
			styleText.setPropsId(props.getId());
			saveStyleText(styleText);
		}
		StylePhoto stylePhoto=props.getStylePhoto();
		if(stylePhoto!=null) {
			stylePhoto.setId(null);
			stylePhoto.setPropsId(props.getId());
			saveStylePhoto(stylePhoto);
		}
		List<Data> dataList=props.getDataList();
		if(dataList!=null) {
			for(Data data:dataList) {
				data.setId(null);
				data.setPropsId(props.getId());
				saveData(data);
			}
		}
		    
	}
	public void saveStyleBorder(StyleBorder styleBorder) {
		styleBorderMapper.insert(styleBorder);
	}
	public void saveStyleBorderBottom(StyleBorderBottom styleBorderBottom) {
		styleBorderBottomMapper.insert(styleBorderBottom);
	}
	public void saveStyleBox(StyleBox styleBox) {
		styleBoxMapper.insert(styleBox);
	}
	public void saveStyleButtonx(StyleButton styleButton) {
		styleButtonMapper.insert(styleButton);
	}
	public void saveStyleLineMark(StyleLineMark styleLineMark) {
		styleLineMarkMapper.insert(styleLineMark);
	}
	public void saveStylePadding(StylePadding stylePadding) {
		stylePaddingMapper.insert(stylePadding);
	}
	public void saveStyleText(StyleText styleText) {
		styleTextMapper.insert(styleText);
	}
	public void saveStylePhoto(StylePhoto stylePhoto) {
		stylePhotoMapper.insert(stylePhoto);
	}
	public void saveData(Data data) {
		dataMapper.insert(data);
	}
	public List<App> searchApps() {
		SysUserEntity sysUser = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute(Constant.CURRENT_USER);
		AppExample appExample=new AppExample();
		appExample.createCriteria().andAppUserIdEqualTo(sysUser.getUserId().toString());
		return appMapper.selectByExample(appExample);
	}
}
