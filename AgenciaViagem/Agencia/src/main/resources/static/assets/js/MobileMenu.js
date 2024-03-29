class MobileMenu{
    constructor(mobileMenu, navList, navLink, navListLi){
        this.mobileMenu = document.querySelector(mobileMenu);
        this.navList = document.querySelector(navList);
        this.navLinks = document.querySelectorAll(navLink);
        this.activeClass = "active";
        this.heandleClick = this.heandleClick.bind(this);
    }

    addClickEvent(){
        this.mobileMenu.addEventListener('click',()=> console.log('click'));
    }

    heandleClick(){
        this.navList.classList.toggle(this.activeClass);
    }

    init(){
        if(this.mobileMenu){
            this.addClickEvent();
        }
        return this;
    }
}

const mobileMenu = new MobileMenu(
    '.mobile-menu',
    '.nav-list',
    '.nav-link',
    '.nav-list li',
);
mobileMenu.init();

