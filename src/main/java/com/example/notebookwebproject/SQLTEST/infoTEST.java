package com.example.notebookwebproject.SQLTEST;

public class infoTEST {
    private int ID, Price, Weight, MemorySize;
    private String Model, ImgURLf, ImgURLb, CPUKind, CPUManufact;
    private float SizeINT;

    public String getModel(){
        return Model;
    }
    public void setModel(String Model){
        this.Model = Model;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getInfoURL(){
        String homepageURL = "http://comalmot.com/notebookinfo/";
        homepageURL = homepageURL + String.valueOf(ID);
        return homepageURL;
    }

    public int getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public String getPriceString(){ //1000단위로 콤마
        int Qprice;
        int threecomma = 1000;
        String PriceString ="";

        Qprice = Price;
        while(Qprice>0){
            if(Qprice != Price)
                PriceString = "," + PriceString;
            if(Qprice%threecomma == 0)
                PriceString = "000" + PriceString;
            else
                PriceString = String.valueOf(Qprice%threecomma) + PriceString;
            Qprice  = Qprice/threecomma;
        }
        return PriceString;
    }

    public int getWeight(){
        return Weight;
    }
    public void setWeight(int Weight){
        this.Weight = Weight;
    }

    public String getImgURLf(){
        return ImgURLf;
    }
    public void setImgURLf(String ImgURLf){
        this.ImgURLf = ImgURLf;
    }

    public String getImgURLb(){
        return ImgURLb;
    }
    public void setImgURLb(String ImgURLb){
        this.ImgURLb = ImgURLb;
    }


    public String getCPUManufact(){return CPUManufact;}
    public void setCPUManufact(String CPUManufact) {this.CPUManufact = CPUManufact;}

    public String getCPUKind(){return CPUKind;}
    public void setCPUKind(String CPUKind) {this.CPUKind = CPUKind;}

    public int getRAMSize(){return MemorySize;}
    public void setRAMSize(int RAMSize) {this.MemorySize = MemorySize;}
    public String getRAMGB(){
        String RAMGB = "";

        RAMGB = "RAM " + String.valueOf(MemorySize) + "GB";

        return RAMGB;
    }

    public float getSizeINT(){return SizeINT;}
    public void setSizeINT(float SizeINT) {this.SizeINT = SizeINT;}
    public String getSizeInch(){
        String SizeInch = "";

        SizeInch = String.valueOf(SizeINT) + "인치";
        return SizeInch;
    }

    public String getStatus(){
        String status;

        status = getCPUManufact() + " / " + getCPUKind()+ " / " + getRAMGB() + " / " + getSizeInch();
        return status;
    }



    private int Resolution, HDDSize, SSDSize, AfterService;
    private float Thick;
    private String Brand, CPUCode, CPUNumber, CPUCore, MemoryType,
            GPUManufact, GPUKind, SSD, OS;
    private Boolean LanCable, LanRadio, Bluetooth, HDMITwo, HDMI, miniDP, DP, DSUB, WebCam,
            USBTypeCTrd, USBTypeC, USBTrdOne, USBTrd, USBSnd, ThunderBolt, eSATA, IEEE, SerialPort, ExpressCard, MultiReader,
            NumKB, BlockKB, MachineKB, RGBLight, KBLight, WaterProofKB, MILSTD, Face, Fingerprint, TPM;

    //표1
    public String getBrand(){
        return Brand;
    }
    public String getWeightString(){
        int Qweight = Weight;
        String WeightString = "";
        if(Qweight >= 1000)
            WeightString = Qweight/1000+"kg";
        else
            WeightString = Qweight+"g";
        return WeightString;
    }
    public float getThick(){
        return Thick;
    }
    public String getResolution(){
        String rstring = "";
        if(Resolution == 1366)
            rstring = "1366×768";
        else if(Resolution == 1440)
            rstring = "1440×900";
        else if(Resolution == 1920)
            rstring = "1920×1080";
        else if(Resolution == 2304)
            rstring = "2304×1440";
        else if(Resolution == 2560)
            if(Brand.equals("애플"))
                rstring = "2560×1600";
            else
                rstring = "2560×1440";
        else if(Resolution == 2880)
            rstring = "2880×1800";
        else if(Resolution == 3840)
            rstring = "3840×2160";
        return rstring;
    }
    public String getCPUCode(){
        return CPUCode;
    }
    public String getCPUNumber(){
        return CPUNumber;
    }
    public String getCPUCore(){
        return CPUCore;
    }

    public int getMemorySize(){
        return MemorySize;
    }
    public String getMemoryType(){
        return MemoryType;
    }
    public String getGPUManufact(){
        return GPUManufact;
    }
    public String getGPUKind(){
        return GPUKind;
    }
    public String getHDDSize(){
        String hddstring = "";
        if(HDDSize !=0){
            if(HDDSize >= 1024)
                hddstring = HDDSize/1000 + "TB";
            else
                hddstring = HDDSize + "GB";}
        return hddstring;
    }
    public String getSSD(){
        return SSD;
    }
    public String getSSDSize(){
        String ssdstring = "";
        if(SSDSize !=0){
            if(SSDSize >= 1024)
                ssdstring = SSDSize/1000 + "TB";
            else
                ssdstring = SSDSize + "GB";}
        return ssdstring;
    }
    public String getOS(){
        return OS;
    }
    public String getAfterService(){
        String asstring = "";
        if(AfterService != 0)
            asstring = AfterService+"년";
        return asstring;
    }

    //표2
    public String getNetworkString(){
        Boolean lc, lr, bt;
        String nstring = "";
        lc = LanCable; lr = LanRadio; bt = Bluetooth;
        if(lc) nstring += "유선랜 / ";
        if(lr) nstring += "무선랜 / ";
        if(bt) nstring += "블루투스 / ";
        if (nstring.length() > 0)
            nstring = nstring.substring(0, nstring.length()-3);
        return nstring;
    }
    public String getVideoString(){
        Boolean ht, hd, mn, dp, ds, wc;
        String nstring = "";
        ht = HDMITwo; hd = HDMI; mn = miniDP; dp = DP; ds = DSUB; wc = WebCam;
        if(ht) nstring += "HDMI 2.0 / ";
        if(hd) nstring += "HDMI / ";
        if(mn) nstring += "miniDP / ";
        if(dp) nstring += "DP / ";
        if(ds) nstring += "D-SUB / ";
        if(wc) nstring += "웹캠 / ";
        if (nstring.length() > 0)
            nstring = nstring.substring(0, nstring.length()-3);
        return nstring;
    }
    public String getTerminalString(){
        Boolean usb1, usb2, usb3, usb4, usb5, tb, es, ie, sp, ec, mr;
        String nstring = "";
        usb1 = USBTypeCTrd; usb2 = USBTypeC; usb3 = USBTrdOne; usb4 = USBTrd; usb5 = USBSnd;
        tb = ThunderBolt; es = eSATA; ie = IEEE; sp = SerialPort; ec = ExpressCard; mr = MultiReader;
        if(usb1) nstring += "USB3.1 Type-C / ";
        if(usb2) nstring += "USB Type-C / ";
        if(usb3) nstring += "USB 3.1 / ";
        if(usb4) nstring += "USB 3.0 / ";
        if(usb5) nstring += "USB 2.0 / ";
        if(tb) nstring += "썬더볼트 / ";
        if(es) nstring += "e-SATA / ";
        if(ie) nstring += "IEEE1394 / ";
        if(sp) nstring += "시리얼포트 / ";
        if(ec) nstring += "익스프레스카드 / ";
        if(mr) nstring += "멀티리더기 / ";
        if (nstring.length() > 0)
            nstring = nstring.substring(0, nstring.length()-3);
        return nstring;
    }
    public String getKeyboardString(){
        Boolean nk, bk, mk, rl, kl, wp, mi;
        String nstring = "";
        nk = NumKB; bk = BlockKB; mk = MachineKB; rl = RGBLight; kl = KBLight; wp = WaterProofKB; mi = MILSTD;
        if(nk) nstring += "숫자키패드 / ";
        if(bk) nstring += "블록키보드 / ";
        if(mk) nstring += "기계식키보드 / ";
        if(rl) nstring += "RGB라이트 / ";
        if(kl) nstring += "키보드라이트 / ";
        if(wp) nstring += "침수지연키보드 / ";
        if(mi) nstring += "MIL-STD / ";
        if (nstring.length() > 0)
            nstring = nstring.substring(0, nstring.length()-3);
        return nstring;
    }
    public String getSecurityString(){
        Boolean fc, fp, tpm;
        String nstring = "";
        fc = Face; fp = Fingerprint; tpm = TPM;
        if(fc) nstring += "얼굴인식 / ";
        if(fp) nstring += "지문인식 / ";
        if(tpm) nstring += "TPM / ";
        if (nstring.length() > 0)
            nstring = nstring.substring(0, nstring.length()-3);
        return nstring;
    }




}
