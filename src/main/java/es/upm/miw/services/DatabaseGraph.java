package es.upm.miw.services;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.documents.core.Article;
import es.upm.miw.documents.core.CashMovement;
import es.upm.miw.documents.core.CashierClosure;
import es.upm.miw.documents.core.FamilyArticle;
import es.upm.miw.documents.core.FamilyComposite;
import es.upm.miw.documents.core.Invoice;
import es.upm.miw.documents.core.Offer;
import es.upm.miw.documents.core.Provider;
import es.upm.miw.documents.core.Shopping;
import es.upm.miw.documents.core.Ticket;
import es.upm.miw.documents.core.Token;
import es.upm.miw.documents.core.User;
import es.upm.miw.documents.core.Voucher;

public class DatabaseGraph {

    private List<User> userList;

    private List<Token> tokenList;

    private List<Provider> providerList;

    private List<Article> articleList;

    private List<FamilyArticle> familyArticleList;

    private List<FamilyComposite> familyCompositeList;

    private List<Voucher> voucherList;

    private List<CashMovement> cashMovementList;

    private List<Ticket> ticketList;

    private List<Shopping> shoppingList;

    private List<Invoice> invoiceList;

    private List<CashierClosure> cashierClosureList;

    private List<Offer> offerList;

    public DatabaseGraph() {
        this.userList = new ArrayList<User>();

        this.tokenList = new ArrayList<Token>();

        this.providerList = new ArrayList<Provider>();

        this.articleList = new ArrayList<Article>();

        this.familyArticleList = new ArrayList<FamilyArticle>();

        this.familyCompositeList = new ArrayList<FamilyComposite>();

        this.voucherList = new ArrayList<Voucher>();

        this.cashMovementList = new ArrayList<CashMovement>();

        this.ticketList = new ArrayList<Ticket>();

        this.shoppingList = new ArrayList<Shopping>();

        this.invoiceList = new ArrayList<Invoice>();

        this.cashierClosureList = new ArrayList<CashierClosure>();

        this.offerList = new ArrayList<Offer>();

    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<FamilyArticle> getFamilyArticleList() {
        return familyArticleList;
    }

    public void setFamilyArticleList(List<FamilyArticle> familyArticleList) {
        this.familyArticleList = familyArticleList;
    }

    public List<FamilyComposite> getFamilyCompositeList() {
        return familyCompositeList;
    }

    public void setFamilyCompositeList(List<FamilyComposite> familyCompositeList) {
        this.familyCompositeList = familyCompositeList;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    public List<CashMovement> getCashMovementList() {
        return cashMovementList;
    }

    public void setCashMovementList(List<CashMovement> cashMovementList) {
        this.cashMovementList = cashMovementList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<CashierClosure> getCashierClosureList() {
        return cashierClosureList;
    }

    public void setCashierClosureList(List<CashierClosure> cashierClosureList) {
        this.cashierClosureList = cashierClosureList;
    }

}
