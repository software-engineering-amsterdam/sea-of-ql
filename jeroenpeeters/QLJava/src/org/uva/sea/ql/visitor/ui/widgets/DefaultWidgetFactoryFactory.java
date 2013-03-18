package org.uva.sea.ql.visitor.ui.widgets;


public class DefaultWidgetFactoryFactory implements WidgetFactoryFactory {
	
	@Override
	public WidgetFactory newBooleanWidgetFactory() {
		return new BooleanWidgetFactory();
	}

	@Override
	public WidgetFactory newIntegerWidgetFactory() {
		return new IntegerWidgetFactory();
	}

	@Override
	public WidgetFactory newMoneyWidgetFactory() {
		return new MoneyWidgetFactory();
	}

	@Override
	public WidgetFactory newTextWidgetFactory() {
		return new TextWidgetFactory();
	}
	
	private static class BooleanWidgetFactory implements WidgetFactory {

		@Override
		public Widget createWidget(String caption, WidgetObserver widgetObserver) {
			return new CheckboxWidget(caption, widgetObserver);
		}
		
	}
	
	private static class IntegerWidgetFactory implements WidgetFactory {

		@Override
		public Widget createWidget(String caption, WidgetObserver widgetObserver) {
			return new NumberWidget(caption, widgetObserver);
		}
		
	}
	
	private static class MoneyWidgetFactory implements WidgetFactory {

		@Override
		public Widget createWidget(String caption, WidgetObserver widgetObserver) {
			return new CurrencyWidget(caption, widgetObserver);
		}
		
	}

	private static class TextWidgetFactory implements WidgetFactory {

		@Override
		public Widget createWidget(String caption, WidgetObserver widgetObserver) {
			return new TextWidget(caption, widgetObserver);
		}
		
	}
	
}